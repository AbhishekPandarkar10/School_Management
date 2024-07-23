package com.nt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Branch;
import com.nt.entity.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

	Student findByIdAndFirstName(int id, String firstName);
	
	Student findByIdAndFirstNameAndMiddleNameAndLastNameAndEmailAndDobAndMobileAndSscAndBranch(int id, 
					String firstName, 
					String middleName, 
					String lastName, 
					String email, 
					String dob, 
					String mobile, 
					String ssc,
					Branch branch);
}
