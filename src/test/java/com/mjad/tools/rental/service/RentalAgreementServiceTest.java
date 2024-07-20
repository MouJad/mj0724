package com.mjad.tools.rental.service;


import com.mjad.tools.rental.model.Tool;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RentalAgreementServiceTest {

  @Autowired
  private ToolService toolService;

  @Test
  public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
    List<Tool> tools = toolService.toolsList();

    Assertions.assertEquals(tools.size(), 3);
  }


}
