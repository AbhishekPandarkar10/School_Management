package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

	@GetMapping("/home")//No need To secure
	public String home() {
		return "Welcome to Ashok It Bank";
	}
	
	@GetMapping("/balance")//Need to secure
	public String getBalance() {
		return "your Current balance is :2346 INR";
	}
	
	@GetMapping("/statement")//Need to secure
	public String getStmt() {
		return "your statement Created and sent to your email id:";
	}
	
	@GetMapping("/myloan")//Need to secure
	public String getMyLoan() {
		return "Your Loan amount due is :450000 INR";
	}
	
	@GetMapping("/contact")//No need To secure
	public String contact() {
		return "Thank you for contacting customer support ,we will get back to you soon";
		
	}
	
}
