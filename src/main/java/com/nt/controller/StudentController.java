package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.request.DTO.StudentRequestDto;
import com.nt.response.Dto.StudentResponseDto;
import com.nt.service.ServiceController;

@RestController
public class StudentController {
	
	@Autowired
	ServiceController ser;
	
	@PostMapping("/add")
	public String saveRecord(@RequestBody StudentRequestDto req) {
		ser.saveRecord(req);
		return "Addes Succes";
	}
	
	@GetMapping("/student/id/{id}")
	public StudentResponseDto getById(@PathVariable("id") int id) {
		StudentResponseDto dto= ser.getById(id);
		return dto;
	}
	
	@GetMapping("/student/id/{id}/firstName/{firstName}")
	public StudentResponseDto getByIdAndName(@PathVariable("id") int id,@PathVariable("firstName") String firstName) {
		StudentResponseDto res=ser.getByIdAndFirstName(id, firstName);
		return res;
	}
	
	@GetMapping("/student/all")
	public StudentResponseDto getByAll(@RequestBody StudentRequestDto dto) {
		return ser.getByAll(dto);
	}
}
