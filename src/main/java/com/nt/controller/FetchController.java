package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.request.DTO.FetchReqDto;
import com.nt.response.Dto.FetchResDto;
import com.nt.service.FetchService;

@RestController
public class FetchController {
	
	@Autowired
	private FetchService ser;
	
	
	@PostMapping("/add/fetch")
	public String add(@RequestBody FetchReqDto dto) {
		ser.add(dto);
		return "Added";
	}
	
	@GetMapping("/get")
	public FetchResDto getById(@RequestBody FetchReqDto dto) {
		return ser.getById(dto);
	}
	
	@GetMapping("/normal")
	public String normalUser() {
		return "yes.i am normal user";
	}
	
	@GetMapping("/admin")
	public String adminUser() {
		return "yes i am admin user";
	}
	
	@GetMapping("/public")
	public String publicUser() {
		return "yes i am publicUser";
	}

}
