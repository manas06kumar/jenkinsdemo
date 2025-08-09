package com.jenkins.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
@RestController
@RequestMapping("/")
public class DemoApplication {
	
	@GetMapping("jenkins")
	public String getJenkins() {
		return "Jenkins Pipeline Triggered";
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
