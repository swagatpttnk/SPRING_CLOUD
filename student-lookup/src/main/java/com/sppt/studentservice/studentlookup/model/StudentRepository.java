package com.sppt.studentservice.studentlookup.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends 
JpaRepository<Student, Long>{
	Student findByRegistrationId(String registrationId);
}
