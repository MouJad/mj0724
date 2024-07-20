package com.mjad.tools.rental.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ValidationServiceTest {

  static ValidationService validationService;

  @BeforeClass
  public static void setBeforeClass() throws Exception {
    validationService = new ValidationService();
  }
  @Test
  public void testValidateInputDiscountPercentThrowsException() {
    Assert.assertThrows(IllegalArgumentException.class,
        ()->{ validationService.validateInput("JAKR", 5, 101, "09/03/15"); });
  }
  @Test
  public void testValidateInputNumberOfDaysThrowsException() {
    Assert.assertThrows(IllegalArgumentException.class,
        ()->{ validationService.validateInput("JAKR", -5, 20, "09/03/15"); });
  }

}
