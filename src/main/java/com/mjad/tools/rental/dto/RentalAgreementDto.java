package com.mjad.tools.rental.dto;

/**
 * @author MJad
 **/
public class RentalAgreementDto {

  private ToolDto toolDto;
  private int rentalDays;
  private String checkoutDate;
  private String dueDate;
  private String dailyRentalCharge;
  private int chargeDaysCount;
  private String preDiscountCharge;
  private int discountPercent;
  private String discountAmount;
  private String finalCharge;
  private boolean isIndependenceDay;
  private boolean isLaborDay;
  private boolean isWeekdayCharge;
  private boolean isWeekendCharge;
  private boolean isHolidayCharge;

  public boolean isIndependenceDay() {
    return isIndependenceDay;
  }

  public void setIndependenceDay(boolean independenceDay) {
    isIndependenceDay = independenceDay;
  }

  public boolean isLaborDay() {
    return isLaborDay;
  }

  public void setLaborDay(boolean laborDay) {
    isLaborDay = laborDay;
  }

  public int getNumberOfDaysInWeekend() {
    return numberOfDaysInWeekend;
  }

  public void setNumberOfDaysInWeekend(int numberOfDaysInWeekend) {
    this.numberOfDaysInWeekend = numberOfDaysInWeekend;
  }

  private int numberOfDaysInWeekend;

  public boolean isWeekdayCharge() {
    return isWeekdayCharge;
  }

  public void setWeekdayCharge(boolean weekdayCharge) {
    isWeekdayCharge = weekdayCharge;
  }

  public boolean isWeekendCharge() {
    return isWeekendCharge;
  }

  public void setWeekendCharge(boolean weekendCharge) {
    isWeekendCharge = weekendCharge;
  }

  public boolean isHolidayCharge() {
    return isHolidayCharge;
  }

  public void setHolidayCharge(boolean holidayCharge) {
    isHolidayCharge = holidayCharge;
  }

  public ToolDto getToolDto() {
    return toolDto;
  }

  public void setToolDto(ToolDto toolDto) {
    this.toolDto = toolDto;
  }

  public int getRentalDays() {
    return rentalDays;
  }

  public void setRentalDays(int rentalDays) {
    this.rentalDays = rentalDays;
  }

  public String getCheckoutDate() {
    return checkoutDate;
  }

  public void setCheckoutDate(String checkoutDate) {
    this.checkoutDate = checkoutDate;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public String getDailyRentalCharge() {
    return dailyRentalCharge;
  }

  public void setDailyRentalCharge(String dailyRentalCharge) {
    this.dailyRentalCharge = dailyRentalCharge;
  }

  public int getChargeDaysCount() {
    return chargeDaysCount;
  }

  public void setChargeDaysCount(int chargeDaysCount) {
    this.chargeDaysCount = chargeDaysCount;
  }

  public String getPreDiscountCharge() {
    return preDiscountCharge;
  }

  public void setPreDiscountCharge(String preDiscountCharge) {
    this.preDiscountCharge = preDiscountCharge;
  }

  public int getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(int discountPercent) {
    this.discountPercent = discountPercent;
  }

  public String getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(String discountAmount) {
    this.discountAmount = discountAmount;
  }

  public String getFinalCharge() {
    return finalCharge;
  }

  public void setFinalCharge(String finalCharge) {
    this.finalCharge = finalCharge;
  }
}
