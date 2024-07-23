package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BranchDao;
import com.nt.entity.Branch;
import com.nt.request.DTO.BranchRequestDto;
import com.nt.response.Dto.BranchResponseDto;

@Service
public class BranchService {
	
	@Autowired 
	private BranchDao dao;

	public Branch add(BranchRequestDto req) {
		Branch b=new Branch();
		BeanUtils.copyProperties(req, b);
		Branch addedBranch=dao.save(b);
		return addedBranch;
		
	}

	public BranchResponseDto getById(int id) {
		Optional<Branch> b=dao.findById(id);
		if(b.isPresent()) {
			Branch br=b.get();
			BranchResponseDto dto=new BranchResponseDto();
			BeanUtils.copyProperties(br, dto);
			return dto;
	}
		return null;
		
}

	public List<BranchResponseDto> getAll() {
		List<Branch> list= dao.findAll();
		  if (list != null && !list.isEmpty()) {
		        return list.stream()
		                   .map(branch -> {
		                       BranchResponseDto dto = new BranchResponseDto();
		                       BeanUtils.copyProperties(branch, dto);
		                       return dto;
		                   })
		                   .collect(Collectors.toList());
		    }
		    return Collections.emptyList();
		
		
	}
}
