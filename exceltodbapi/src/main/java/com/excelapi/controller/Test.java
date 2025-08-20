package com.excelapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestApi")

public class Test {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@PostMapping("/Add")
	
	public int add(@RequestParam int value1, @RequestParam int value2) {
		
	logger.info("Value1: " +value1+ " Value2: " +value2 );

	int sum = value1 + value2;
	
	logger.info("Sum: " +sum);
	
	return sum;
	}
	
}
