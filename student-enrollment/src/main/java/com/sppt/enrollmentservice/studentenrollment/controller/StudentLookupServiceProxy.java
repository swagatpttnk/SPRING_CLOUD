package com.sppt.enrollmentservice.studentenrollment.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sppt.enrollmentservice.studentenrollment.model.RegistrationDetails;

//@FeignClient(name="student-lookup-service", url="localhost:5000")
@FeignClient(name="student-lookup-service")
@RibbonClient(name="student-lookup-service")
public interface StudentLookupServiceProxy {
	@GetMapping("/student-lookup/{regId}")
	public RegistrationDetails lookupStudent(@PathVariable("regId") String regId);
}