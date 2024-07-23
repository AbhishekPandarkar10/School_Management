package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
	private int id;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="middle_name")
	private String middleName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="mobile")
	private String mobile;
	
	@Column(name ="dob")
	private String dob;
	
	@Column(name ="ssc_marks")
	private String ssc;
	
	@ManyToOne
	@JoinColumn(name ="branch_id")
	private Branch branch;

	
}
