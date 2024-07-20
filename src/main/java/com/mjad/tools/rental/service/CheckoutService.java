package com.mjad.tools.rental.service;

import com.mjad.tools.rental.dto.RentalAgreementDto;
import com.mjad.tools.rental.dto.ToolDto;
import com.mjad.tools.rental.model.RentalCharge;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MJad
 **/
@Service
public class CheckoutService implements ICheckout {
  @Autowired
  private ITool toolService;
  @Autowired
  private IRentalCharge rentalChargeService;
  @Autowired
  private UtilityService utilityService;
  @Autowired
  private RentalAgreementService rentalAgreementService;
  private ToolDto toolDto = null;
  private RentalAgreementDto rentalAgreementDto = new RentalAgreementDto();

  @Override
  public void processCheckout(String toolCode, int rentalDayCount, int discountPercent, String checkoutDate) {
    createToolDto(toolCode);
    rentalAgreementDto.setToolDto(toolDto);
    populateRentalAgreementDto(toolDto.getType(), rentalDayCount, checkoutDate);
    LocalDate dueDate = calculateDueDate(rentalDayCount, checkoutDate);
    rentalAgreementDto.setDueDate(utilityService.formatDate(dueDate));             //(dueDate.format(dateFormatter));
    rentalAgreementDto.setIndependenceDay(isIndependenceDay(dueDate, checkoutDate));
    rentalAgreementDto.setLaborDay(isLaborDay(utilityService.getLocalDate(checkoutDate), dueDate));
    rentalAgreementDto.setChargeDaysCount(getChargeDays(rentalDayCount));
    rentalAgreementDto.setDiscountPercent(getDiscountPercent(discountPercent));
    double preDiscountCharge = getPreDiscountCharge();
    double discountAmount = getDiscountAmount(discountPercent, preDiscountCharge);
    double finalCharge = getFinalCharge(preDiscountCharge, discountAmount);
    rentalAgreementDto.setPreDiscountCharge("" + utilityService.roundUpTwoDecimal(preDiscountCharge));
    rentalAgreementDto.setDiscountAmount("" + utilityService.roundUpTwoDecimal(discountAmount));
    rentalAgreementDto.setFinalCharge("" + utilityService.roundUpTwoDecimal(finalCharge));

    // I Stored the rental agreement in the DTO to pass around, but I did not persist it to the database.
    rentalAgreementService.saveRentalAgreement(rentalAgreementDto);
  }
  private void createToolDto(String toolCode) {
    toolService.toolsList().stream()
        .filter(tool -> tool.getCode().equals(toolCode))
        .forEach(tool -> toolDto = new ToolDto(tool.getCode(), tool.getType(), tool.getBrand()));
  }
  private boolean isWeekendCharge() {
    return rentalAgreementDto.isWeekendCharge();
  }
  private boolean isHolidayCharge() {
    return rentalAgreementDto.isHolidayCharge();
  }
  private LocalDate calculateDueDate(int rentalDayCount, String checkoutDate) {
    LocalDate dueDate = utilityService.addRentalDaysToCheckoutDate(rentalDayCount, utilityService.getLocalDate(checkoutDate));
    return dueDate;
  }
  private void populateRentalAgreementDto(String type, int rentalDayCount, String checkoutDate) {
    List<RentalCharge> rentCharges = rentalChargeService.rentalChargelist();
    for(RentalCharge charge : rentCharges){
      if (charge.getType().equalsIgnoreCase(type)) {
        setRentalAgreementDto(charge, rentalDayCount, checkoutDate);
        break;
      }
    }
  }
  private void setRentalAgreementDto(RentalCharge rentalCharge, int rentalDayCount, String checkoutDate) {
    rentalAgreementDto.setDailyRentalCharge(rentalCharge.getDailyChargeAmt());
    rentalAgreementDto.setHolidayCharge(rentalCharge.isHolidayCharge());
    rentalAgreementDto.setWeekdayCharge(rentalCharge.isWeekdayCharge());
    rentalAgreementDto.setWeekendCharge(rentalCharge.isWeekendCharge());
    rentalAgreementDto.setRentalDays(rentalDayCount);
    rentalAgreementDto.setCheckoutDate(checkoutDate);
  }
  private int getChargeDays(int rentalDayCount) {
    int chargeDays = rentalDayCount;
    if (rentalAgreementDto.isIndependenceDay() || rentalAgreementDto.isLaborDay() ) {
      if (!isHolidayCharge()) {
        chargeDays -= 1;
      }
    }
    if (!isWeekendCharge()) {
      chargeDays -= rentalAgreementDto.getNumberOfDaysInWeekend();
    }
    return chargeDays;
  }
  private double getPreDiscountCharge() {
    return rentalAgreementDto.getChargeDaysCount() * Double.valueOf(rentalAgreementDto.getDailyRentalCharge());
  }
  private int getDiscountPercent(int discountPercent) {
      return discountPercent;
  }
  private double getDiscountAmount(int discountPercent, double preDiscountCharge) {
    return (discountPercent * preDiscountCharge) / 100;
  }
  private double getFinalCharge(double preDiscountCharge, double discountAmount) {
    return preDiscountCharge - discountAmount;
  }
  private boolean isIndependenceDay(LocalDate dueDate, String checkoutDate) {
    LocalDate checkDate = utilityService.getLocalDate(checkoutDate);
    LocalDate forth = LocalDate.parse(utilityService.getIndependenceDay(checkDate));
    boolean isIndependenceDay = false;
    if (checkDate.isBefore(forth) && dueDate.isAfter(forth)) {
      isIndependenceDay = true;
    }
    return isIndependenceDay;
  }
  private boolean isLaborDay(LocalDate checkoutDate, LocalDate dueDate) {
    boolean isLaborDay = false;
    int numberOfDaysInWeekend = 0;
    LocalDate copyCheckDate = checkoutDate;
    List<String> checkoutDateWithLabor = utilityService.possibleLaborDays(copyCheckDate.getYear() + "");
    while (ChronoUnit.DAYS.between(copyCheckDate, dueDate) > 0) {
      if (copyCheckDate.getDayOfWeek().getValue() == 1 && checkoutDateWithLabor.contains(copyCheckDate.toString())) {
        isLaborDay = true;
      }
      if (copyCheckDate.getDayOfWeek().getValue() == 6 || copyCheckDate.getDayOfWeek().getValue() == 7) {
        numberOfDaysInWeekend += 1;
      }
      copyCheckDate = copyCheckDate.plusDays(1);
    }
    rentalAgreementDto.setNumberOfDaysInWeekend(numberOfDaysInWeekend);
    return isLaborDay;
  }
}
