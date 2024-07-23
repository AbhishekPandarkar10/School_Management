package com.nt.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.StudentDao;
import com.nt.entity.Student;
import com.nt.request.DTO.StudentRequestDto;
import com.nt.response.Dto.StudentResponseDto;

@Service
public class ServiceController {
	
	@Autowired
	StudentDao dao;
	
	public void saveRecord(StudentRequestDto dto) {
		Student s=new Student();
		BeanUtils.copyProperties(dto, s);
		dao.save(s);
	}

	public StudentResponseDto getById(int id) {
		Optional<Student> res=dao.findById(id);
		if(res.isPresent()) {
			Student s= res.get();
			StudentResponseDto dto=new StudentResponseDto();
			 BeanUtils.copyProperties(s, dto);
		        return dto;
		}
		return null;
		
	}

	public StudentResponseDto getByIdAndFirstName(int id, String firstName) {
		Student s=dao.findByIdAndFirstName(id,firstName);
		if(s!=null) {
			StudentResponseDto res=new StudentResponseDto();
			res.setId(s.getId());
			res.setFirstName(s.getFirstName());
			return res;
			
		}
		else {
			return null;
		}
		
	}

	public StudentResponseDto getByAll(StudentRequestDto dto) {
		Student s=dao.findByIdAndFirstNameAndMiddleNameAndLastNameAndEmailAndDobAndMobileAndSscAndBranch(dto.getId(),dto.getFirstName(),dto.getMiddleName(),dto.getLastName(),dto.getEmail(),dto.getDob(),dto.getMobile(),dto.getSsc(),dto.getBranch());
		
		//Student s = dao.findByStudentDTO(dto);
		//You can use this are as follow to avoid long code

		if(s!=null)
		{
			StudentResponseDto res=new StudentResponseDto();
			BeanUtils.copyProperties(s, res);
			return res;
		}
		return null;
	}
}
