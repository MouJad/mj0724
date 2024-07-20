package com.mjad.tools.rental.service;

import com.mjad.tools.rental.model.Tool;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MJad
 **/
@Service
public class ValidationService implements IValidate {
  private static String TOOL_CODE_EXCEPTION            = "############  Tool Code is invalid, try codes from the table above   ############\n";
  private static String NUMBER_OF_DAYS_EXCEPTION       = "############  Rental day count should be greater or equal 1  ############\n";
  private static String DISCOUNT_PERCENT_EXCEPTION     = "############  Discount percent should be in the range of 0-100   ############\n";
  private static String CHECKOUT_DATE_FORMAT_EXCEPTION = "############  Date format is invalid, try again (mm/dd/yy)     ############\n";

  @Autowired
  private ITool toolService;
  @Override
  public void validateInput(String toolCode, int numberOfDays, int discountPercent, String checkoutDate) {
    if (numberOfDays < 1) {
      throwException(NUMBER_OF_DAYS_EXCEPTION);
    }
    if (discountPercent < 0 || discountPercent > 100) {
      throwException(DISCOUNT_PERCENT_EXCEPTION);
    }
    // Not in the scope of this spec: but I added the validation for the toolCode and the checkoutDate because the terminal input allows any/all characters.
    // Usually in the UI interface (ex: Web App, mobile, GUI) we can validate this input at the form input type-ahead or calendar selector.
    if (!populateToolCodes().contains(toolCode)) {
      throwException(TOOL_CODE_EXCEPTION);
    }
    if (!isDateFormatValid(checkoutDate)) {
      throwException(CHECKOUT_DATE_FORMAT_EXCEPTION);
    }
  }
  private List<String> populateToolCodes() {
    return toolService.toolsList()
        .stream()
        .map(Tool::getCode)
        .collect(Collectors.toList());
  }
  private boolean isDateFormatValid(String checkoutDate) {
    checkDateLength(checkoutDate);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
    try {
      LocalDate.parse(checkoutDate, dtf);
    }catch(DateTimeParseException dtEx) {
      dtEx.printStackTrace();
      return false;
    }
    return true;
  }
  private void checkDateLength(String checkoutDate) {
    if (checkoutDate.split("/").length != 3) {
      throwException(CHECKOUT_DATE_FORMAT_EXCEPTION);
    }
  }
  private void throwException(String errorMessage) {
    throw new IllegalArgumentException(errorMessage);
  }
}
