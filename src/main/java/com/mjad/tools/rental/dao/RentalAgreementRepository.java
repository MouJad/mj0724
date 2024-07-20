package com.mjad.tools.rental.dao;

import com.mjad.tools.rental.model.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MJad
 **/
public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long> {
}
