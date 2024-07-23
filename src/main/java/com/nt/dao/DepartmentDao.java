package com.nt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

	Department findByIdAndDepartment(int id,String department);
	
	List<Department> findAll();
}
