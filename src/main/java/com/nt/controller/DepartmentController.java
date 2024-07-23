package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.request.DTO.DepartmentReqDto;
import com.nt.response.Dto.DepartmentResdto;
import com.nt.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService ser;
	
	@PostMapping("/department/add")
	public String saveall(@RequestBody DepartmentReqDto dto) {
		ser.saveall(dto);
		System.out.println("come");
		return "Added Success";
	}
	
	@GetMapping("/department/id/{id}")
	public DepartmentResdto getById(@PathVariable("id") int id) {
		return ser.getById(id);
	}
	
	@GetMapping("/all/dep")
	public DepartmentResdto getByDepartmentReqDto(@RequestBody DepartmentReqDto dto) {
		return ser.getByDepartmentReqDto(dto);
		
	}
	
	@GetMapping("/all/departments")
	public List<DepartmentResdto> getAll() {
		return ser.getAll();
	}
	
	@PostMapping("/andy/id/{id}/department/{department}")
	public String add(@PathVariable("id") int id,@PathVariable("department") String department) {
		ser.add(id,department);
		return "added";
	}
	
	@PostMapping("/andy")
	public String add(@RequestBody DepartmentReqDto dto) {
		ser.add2(dto);
		return null;
		
	}

}
