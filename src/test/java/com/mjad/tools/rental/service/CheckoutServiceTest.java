package com.mjad.tools.rental.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Configurable
public class CheckoutServiceTest {

  static CheckoutService checkoutService;
  @Autowired
  CheckoutService checkoutService1;

  @BeforeClass
  public static void setBeforeClass() throws Exception {
    checkoutService = new CheckoutService();
  }

  @Test
  public void testProcessCheckout() {
    checkoutService.processCheckout("JAKR", 5, 101, "09/03/15");
  }


}
