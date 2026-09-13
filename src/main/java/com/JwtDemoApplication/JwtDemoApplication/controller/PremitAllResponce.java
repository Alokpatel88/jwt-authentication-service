package com.JwtDemoApplication.JwtDemoApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PremitAllResponce {
	@GetMapping("/premitAllResponce")
	public String getPremitAllResponce() {
		return "Premit All Responce";
	}

}
