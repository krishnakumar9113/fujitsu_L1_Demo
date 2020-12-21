package com.fujitsu.L1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
//@ComponentScan(basePackages={"com.fujitsu.L1"})
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		 logger.info("Server started");
		SpringApplication.run(DemoApplication.class, args);
	}

}
