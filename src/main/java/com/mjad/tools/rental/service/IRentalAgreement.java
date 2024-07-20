package com.mjad.tools.rental.service;

import com.mjad.tools.rental.dto.RentalAgreementDto;

/**
 * @author MJad
 **/
public interface IRentalAgreement {

  public void saveRentalAgreement(RentalAgreementDto rentalAgreementDto);
  public RentalAgreementDto getRentalAgreementDto();

}
