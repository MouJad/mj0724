package com.mjad.tools.rental.service;

import com.mjad.tools.rental.dao.ToolRepository;
import com.mjad.tools.rental.model.Tool;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MJad
 **/
@Service
public class ToolService implements ITool {

  @Autowired
  private ToolRepository toolRepository;

  @Override
  public List<Tool> toolsList() {
    return toolRepository.findAll();
  }

}
