package com.nt.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.FetchDao;
import com.nt.entity.Fetch;
import com.nt.request.DTO.FetchReqDto;
import com.nt.response.Dto.FetchResDto;


@Service
public class FetchService {
	
	@Autowired
	private FetchDao dao;

	public void add(FetchReqDto dto) {
		System.out.print("added");
		Fetch f=new Fetch();
		BeanUtils.copyProperties(dto, f);
		dao.save(f);
	}

	public FetchResDto getById(FetchReqDto dto) {
		Optional<Fetch> opt=dao.findById(dto.getId());
		if(opt.isPresent()) {
			Fetch f=opt.get();
			FetchResDto res=new FetchResDto();
			BeanUtils.copyProperties(f, res);
			return res;
		}
		return null;
	}

}
