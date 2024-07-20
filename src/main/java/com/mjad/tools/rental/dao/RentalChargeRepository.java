package com.mjad.tools.rental.dao;

import com.mjad.tools.rental.model.RentalCharge;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MJad
 **/
public interface RentalChargeRepository extends JpaRepository<RentalCharge, Long> {
}
