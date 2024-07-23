package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Branch;
import com.nt.request.DTO.BranchRequestDto;
import com.nt.response.Dto.BranchResponseDto;
import com.nt.service.BranchService;

@RestController
@RequestMapping("/branches")
public class BranchController {
	
	@Autowired
	private BranchService ser;
	
	@PostMapping
	public String add(@RequestBody BranchRequestDto req) {
		Branch addedObject=ser.add(req);
		if(addedObject!=null) {
			return "Added Success";
		}
		return "Not Added";
	}
	
	@GetMapping("/id/{id}")
	public BranchResponseDto getById(@PathVariable ("id") int id) {
		BranchResponseDto dto= ser.getById(id);
		if(dto!=null) {
			return dto;
		}
		return null;
	}

	@GetMapping("/all")
	public List<BranchResponseDto> getAll() {
		return ser.getAll();
	}
}
