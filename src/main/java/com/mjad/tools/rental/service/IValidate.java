package com.mjad.tools.rental.service;

/**
 * @author MJad
 **/
public interface IValidate {
  public void validateInput(String toolCode, int numberOfDays, int discountPercent, String checkoutDate);

}
