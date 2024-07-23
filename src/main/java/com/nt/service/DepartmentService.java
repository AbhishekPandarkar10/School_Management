package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.DepartmentDao;
import com.nt.entity.Department;
import com.nt.request.DTO.DepartmentReqDto;
import com.nt.response.Dto.DepartmentResdto;


@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao dao;

	public void saveall(DepartmentReqDto dto) {
		Department dep=new Department();
		BeanUtils.copyProperties(dto, dep);
		dao.save(dep);
	
	}

	public DepartmentResdto getById(int id) {
		Optional<Department> opt=dao.findById(id);
		
		if(opt.isPresent()) {
			Department d=opt.get();
			DepartmentResdto res=new DepartmentResdto();
			BeanUtils.copyProperties(d, res);
			return res;
			
		}
		return null;
		
	}

	public DepartmentResdto getByDepartmentReqDto(DepartmentReqDto dto) {
		
		Department d=dao.findByIdAndDepartment(dto.getId(),dto.getDepartment());
		
		DepartmentResdto res=new DepartmentResdto();
		if(d!=null) {
			BeanUtils.copyProperties(d, res);
			return res;
		}
		return null;
	}
	
	public List<DepartmentResdto> getAll() {
		List<Department> list=dao.findAll();
		 if (list != null && !list.isEmpty()) {
		        return list.stream()
		                   .map(dep -> {
		                	   DepartmentResdto dto = new DepartmentResdto();
		                       BeanUtils.copyProperties(dep, dto);
		                       return dto;
		                   })
		                   .collect(Collectors.toList());
		    }
		    return null;
	}

	public void add(int id, String department) {
		Department k=new Department();
		k.setId(id);
		k.setDepartment(department);
		dao.save(k);	
	}

	public void add2(DepartmentReqDto dto) {
		Department d=new Department();
		BeanUtils.copyProperties(dto, d);
		dao.save(d);	
	}
	
}
