package com.mjad.tools.rental.controller;

import com.mjad.tools.rental.dto.RentalAgreementDto;
import com.mjad.tools.rental.model.RentalCharge;
import com.mjad.tools.rental.model.Tool;
import com.mjad.tools.rental.service.ICheckout;
import com.mjad.tools.rental.service.IRentalCharge;
import com.mjad.tools.rental.service.ITool;
import com.mjad.tools.rental.service.IValidate;
import com.mjad.tools.rental.service.RentalAgreementService;
import com.mjad.tools.rental.service.UtilityService;
import com.mjad.tools.rental.view.DisplayView;
import com.mjad.tools.rental.view.RentalAgreementView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author MJad
 **/
@Controller
public class DisplayController {

  @Autowired
  private ITool toolService;
  @Autowired
  private IRentalCharge rentalChargeService;
  @Autowired
  private ICheckout checkoutService;
  @Autowired
  private IValidate validateService;
  @Autowired
  private UtilityService utilityService;
  @Autowired
  private RentalAgreementService rentalAgreementService;

  public void displayTerminal() {
    List<Tool> tools = toolService.toolsList();
    List<RentalCharge> rentCharges = rentalChargeService.rentalChargelist();
    new DisplayView(this).initiateDisplay(tools, rentCharges);
  }

  public void checkout(String toolCode, int rentalDayCount, int discountPercent, String checkoutDate) {
    String fixedCheckoutDate = utilityService.appendZeroToDate(checkoutDate);
    validateService.validateInput(toolCode, rentalDayCount, discountPercent, fixedCheckoutDate);
    checkoutService.processCheckout(toolCode, rentalDayCount, discountPercent, fixedCheckoutDate);
    RentalAgreementDto rentalAgreementDto = rentalAgreementService.getRentalAgreementDto();
    new RentalAgreementView().printRentalAgreement(rentalAgreementDto);
  }
  
}
