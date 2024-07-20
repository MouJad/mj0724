package com.mjad.tools.rental.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * @author MJad
 **/
@Entity
@Table(name="RENTAL_AGREEMENT")
public class RentalAgreement {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id",referencedColumnName = "id")
  private Tool tool;

  private int rentalDays;
  private Date checkoutDate;
  private Date dueDate;
  private String dailyRentalCharge;
  private int chargeDaysCount;
  private int preDiscountCharge;
  private int discountPercent;
  private String discountAmount;
  private String finalCharge;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Tool getTools() {
    return tool;
  }

  public void setTools(Tool tool) {
    this.tool = tool;
  }

  public int getRentalDays() {
    return rentalDays;
  }

  public void setRentalDays(int rentalDays) {
    this.rentalDays = rentalDays;
  }

  public Date getCheckoutDate() {
    return checkoutDate;
  }

  public void setCheckoutDate(Date checkoutDate) {
    this.checkoutDate = checkoutDate;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
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

  public int getPreDiscountCharge() {
    return preDiscountCharge;
  }

  public void setPreDiscountCharge(int preDiscountCharge) {
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

  @Override
  public String toString() {
    return "Id: '" + this.id;
  }
}
