package com.mjad.tools.rental.service;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UtilityServiceTest {
  static UtilityService utilityService;

  @BeforeClass
  public static void setBeforeClass() throws Exception {
    utilityService = new UtilityService();
  }
  @Test
  public void testAppendZeroToDate() {
    Assert.assertEquals("07/01/23", utilityService.appendZeroToDate(("7/1/23")));
  }
  @Test
  public void testPossibleLaborDay() {
    Assert.assertTrue( utilityService.possibleLaborDays("2024").contains("2024-09-01"));
  }
  @Test
  public void testLaborDayFor2024() {
    Assert.assertTrue(utilityService.possibleLaborDays("2024").contains("2024-09-02"));
  }
  @Test
  public void testIndependenceDayForCheckoutYear() {
    LocalDate checkoutDate = LocalDate.now();
    Assert.assertEquals("2024-07-04", utilityService.getIndependenceDay(checkoutDate));
  }
  @Test
  public void testRoundupTwoDecimal() {
    Assert.assertEquals("99.99", utilityService.roundUpTwoDecimal(99.9889999));
    Assert.assertEquals("100.00", utilityService.roundUpTwoDecimal(99.9999999));
  }
  @Test
  public void testAddRentalDaysToCheckoutDate() {
    LocalDate checkoutDate = LocalDate.parse("2022-08-31");
    LocalDate expected = LocalDate.parse("2022-09-05");
    Assert.assertEquals(expected, utilityService.addRentalDaysToCheckoutDate(5, checkoutDate));
  }
  @Test
  public void tesFormatDate() {
    LocalDate date = LocalDate.parse("2024-01-24");
    String expected = "01/24/24";
    Assert.assertEquals(expected, utilityService.formatDate(date).toString());
  }

}
