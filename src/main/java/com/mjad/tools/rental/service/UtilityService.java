package com.mjad.tools.rental.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * @author MJad
 **/
@Service
public class UtilityService {

  private static final DecimalFormat df = new DecimalFormat("#,###.00");
  private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
  public String appendZeroToDate(String checkoutDate) {
    if (checkoutDate.length() == 8) {
      return checkoutDate;
    }
    String[] dateTokens = checkoutDate.split("/");
    for (int i = 0; i < dateTokens.length; i++) {
      if (dateTokens[i].length() == 1) {
        dateTokens[i] = '0' + dateTokens[i];
      }
    }
    return String.join("/", dateTokens);
  }

  public List<String> possibleLaborDays(String year) {
    List<String> possibleLaborDays = Arrays.asList("09-01", "09-02", "09-03", "09-04", "09-05", "09-06", "09-07" );
    return possibleLaborDays.stream()
        .map(dt -> new String(year + "-" + dt))
        .collect(Collectors.toList());
  }

  public String getIndependenceDay(LocalDate checkoutDate) {
    return checkoutDate.getYear() + "-07-04";
  }

  public String roundUpTwoDecimal(double amount) {
    return df.format(amount);
  }

  public LocalDate addRentalDaysToCheckoutDate(int rentalDayCount, LocalDate checkoutDate) {
    return checkoutDate.plusDays(rentalDayCount);
  }
  public LocalDate getLocalDate(String checkoutDate) {
    return LocalDate.parse(checkoutDate, dateFormatter);
  }
  public String formatDate(LocalDate localDate) {
    return localDate.format(dateFormatter);
  }

}
