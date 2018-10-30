package com.sppt.enrollmentservice.studentenrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sppt.enrollmentservice.studentenrollment")
public class StudentEnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEnrollmentApplication.class, args);
	}
}
