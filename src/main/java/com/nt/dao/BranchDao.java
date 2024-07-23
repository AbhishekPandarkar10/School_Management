package com.nt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Branch;

public interface BranchDao extends CrudRepository<Branch, Integer>{

	List<Branch> findAll();
}
