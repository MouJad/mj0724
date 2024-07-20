package com.mjad.tools.rental.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author MJad
 **/
@Entity
@Table(name="RENTAL_CHARGE")
public class RentalCharge {

  @Id
  @GeneratedValue
  private Long id;
  @Column(insertable=false, updatable=false)
  private String type;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id",referencedColumnName = "id")
  private Tool tool;

  @Column(name = "daily_charge")
  private String dailyChargeAmt;
  @Column(name = "weekday_charge")
  private boolean isWeekdayCharge;
  @Column(name = "weekend_charge")
  private boolean isWeekendCharge;
  @Column(name = "holiday_charge")
  private boolean isHolidayCharge;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDailyChargeAmt() {
    return dailyChargeAmt;
  }

  public void setDailyChargeAmt(String dailyChargeAmt) {
    this.dailyChargeAmt = dailyChargeAmt;
  }

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

  @Override
  public String toString() {
    return "Id: '" + this.id + "', Type: '" + this.type + "', Daily Charge: '" + this.getDailyChargeAmt() +
        "', Weekday Charge: '" + this.isWeekdayCharge + "', Weekend Charge: '" + this.isWeekendCharge + "', Holiday Charge: '" + this.isHolidayCharge;
  }

}
