package com.mjad.tools.rental.service;

import com.mjad.tools.rental.dao.RentalAgreementRepository;
import com.mjad.tools.rental.dto.RentalAgreementDto;
import com.mjad.tools.rental.model.RentalAgreement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MJad
 **/
@Service
public class RentalAgreementService implements IRentalAgreement {
  @Autowired
  private RentalAgreementRepository rentAgreementRepo;
  private RentalAgreementDto rentalAgreementDto;
  @Override
  public void saveRentalAgreement(RentalAgreementDto rentalAgreementDto) {
    this.rentalAgreementDto = rentalAgreementDto;
  }

  @Override
  public RentalAgreementDto getRentalAgreementDto() {
    return rentalAgreementDto;
  }

  public List<RentalAgreement> list() {
    return rentAgreementRepo.findAll();
  }

}
