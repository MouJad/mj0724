package com.mjad.tools.rental.service;

import com.mjad.tools.rental.dao.RentalChargeRepository;
import com.mjad.tools.rental.model.RentalCharge;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MJad
 **/
@Service
public class RentalChargeService implements IRentalCharge {

  @Autowired
  private RentalChargeRepository rentChargeRepo;

  @Override
  public List<RentalCharge> rentalChargelist() {
    return rentChargeRepo.findAll();
  }
}
