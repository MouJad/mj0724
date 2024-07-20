package com.mjad.tools.rental.view;

import com.mjad.tools.rental.dto.RentalAgreementDto;

/**
 * @author MJad
 **/
public class RentalAgreementView {
  public RentalAgreementView() {}

  public void printRentalAgreement(RentalAgreementDto rentalAgreementDto) {
    String cellPadding = "%-25s |%n";
    System.out.format("%n");
    System.out.format("+----------------------------------------------------------+%n");
    System.out.format("|             RENTAL AGREEMENT INVOICE DETAILS             |%n");
    System.out.format("+----------------------------------------------------------+%n");
    System.out.format("| Tool Code:                 |   ");
    System.out.format(cellPadding, rentalAgreementDto.getToolDto().getCode());
    System.out.format("| Tool Type:                 |   ");
    System.out.format(cellPadding, rentalAgreementDto.getToolDto().getType());
    System.out.format("| Tool Brand:                |   ");
    System.out.format(cellPadding, rentalAgreementDto.getToolDto().getBrand());
    System.out.format("| Tool Rental Days:          |   ");
    System.out.format(cellPadding, rentalAgreementDto.getRentalDays());
    System.out.format("| Tool Checkout Date:        |   ");
    System.out.format(cellPadding, rentalAgreementDto.getCheckoutDate());
    System.out.format("| Tool Due Date:             |   ");
    System.out.format(cellPadding, rentalAgreementDto.getDueDate());
    System.out.format("| Tool Daily Charge:         |   ");
    System.out.format(cellPadding, "$" + rentalAgreementDto.getDailyRentalCharge());
    System.out.format("| Tool Charge Days:          |   ");
    System.out.format(cellPadding, rentalAgreementDto.getChargeDaysCount());
    System.out.format("| Tool Weekend Days:         |   ");
    System.out.format(cellPadding, rentalAgreementDto.getNumberOfDaysInWeekend());
    System.out.format("| Tool Independence Day:     |   ");
    System.out.format(cellPadding, isHoliday(rentalAgreementDto.isIndependenceDay()));
    System.out.format("| Tool Labor Day:            |   ");
    System.out.format(cellPadding, isHoliday(rentalAgreementDto.isLaborDay()));
    System.out.format("| Tool Holiday Charge:       |   ");
    System.out.format(cellPadding, isHoliday(rentalAgreementDto.isHolidayCharge()));
    System.out.format("| Tool Weekend Charge:       |   ");
    System.out.format(cellPadding, isHoliday(rentalAgreementDto.isWeekendCharge()));
    System.out.format("| Tool PreDiscount Charge:   |   ");
    System.out.format(cellPadding, "$" + rentalAgreementDto.getPreDiscountCharge());
    System.out.format("| Tool Discount Percent:     |   ");
    System.out.format(cellPadding, rentalAgreementDto.getDiscountPercent()  + "%");
    System.out.format("| Tool Discount Amount:      |   ");
    System.out.format(cellPadding, "$" + rentalAgreementDto.getDiscountAmount());
    System.out.format("| Tool Final Charge:         |   ");
    System.out.format(cellPadding, "$" + rentalAgreementDto.getFinalCharge());
    System.out.format("+----------------------------------------------------------+%n");

  }

  private String isHoliday(boolean holiday) {
    return holiday ? "Yes" : "No";
  }

}
