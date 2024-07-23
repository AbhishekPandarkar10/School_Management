package com.nt.response.Dto;


import com.nt.entity.Branch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
	
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobile;
	private String dob;
	private String ssc;
    private Branch branch;

}
