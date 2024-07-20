package com.mjad.tools.rental.dao;

import com.mjad.tools.rental.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MJad
 **/
public interface ToolRepository extends JpaRepository<Tool, Long> {
}
