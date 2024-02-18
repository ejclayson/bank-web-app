package com.tesda.bankwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BankWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankWebAppApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello " + name + "!");
	}

	@GetMapping("/hi")
	public String hiUser(@RequestParam(value = "user", defaultValue = "User") String user){
		return String.format("hi %s!", user);
	}

	@GetMapping("/nameAge")
	public String nameAge(@RequestParam(value = "name", defaultValue = "User") String name,
						  @RequestParam(value = "age", defaultValue = "18") String age
	){
		return String.format("hello %s! Your age is %s.", name, age);
//		return String.format("Your age is %s", age);
	}


}
