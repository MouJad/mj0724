package com.mjad.tools.rental.service;


import com.mjad.tools.rental.dto.RentalAgreementDto;

/**
 * @author MJad
 **/
public interface ICheckout {

  public void processCheckout(String toolCode, int rentalDayCount, int discountPercent, String checkoutDate);

}
