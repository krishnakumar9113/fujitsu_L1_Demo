package com.fujitsu.L1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
//@ComponentScan(basePackages={"com.fujitsu.L1"})
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		 logger.info("Server started");
		SpringApplication.run(DemoApplication.class, args);
	}
	  @Configuration

	    public class WebConfig implements WebMvcConfigurer {     

	        @Override

	        public void addResourceHandlers(ResourceHandlerRegistry registry) {

	 

	            registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/")

	                    .setCachePeriod(0);

	        }

	    }
}
