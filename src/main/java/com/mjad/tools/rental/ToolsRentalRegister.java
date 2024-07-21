package com.mjad.tools.rental;

import com.mjad.tools.rental.controller.DisplayController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MJad
 **/
@SpringBootApplication
public class ToolsRentalRegister implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(ToolsRentalRegister.class);
	@Autowired
	private DisplayController displayController;

	public static void main(String[] args) {
		logger.info("STARTING THE APPLICATION");
		SpringApplication.run(ToolsRentalRegister.class, args);
		logger.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		displayController.displayTerminal();
		logger.info("EXECUTING : command line runner");
	}

}
