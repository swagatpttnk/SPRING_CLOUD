package com.sppt.enrollmentservice.studentenrollment.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sppt.enrollmentservice.studentenrollment.model.RegistrationDetails;
@RestController
public class StudentEnrollmentController {

	@Autowired
	StudentLookupServiceProxy studentLookup_proxy;
	/*Using FEIGN Client*/
	@GetMapping("/student-enrollment-feign/{regId}")
	public RegistrationDetails getRegistrationDetails(@PathVariable String regId){
		
		RegistrationDetails response = studentLookup_proxy.lookupStudent(regId);
		RegistrationDetails dtls=new RegistrationDetails(); 
		if(response!=null && (response.getRegistrationId()!=null ||"".equalsIgnoreCase(response.getRegistrationId()))) {
			dtls.setId(response.getId());
			dtls.setFirstName(response.getFirstName());
			dtls.setLastName(response.getLastName());
			dtls.setRegistrationId(response.getRegistrationId());
			dtls.setPort(response.getPort());
			dtls.setRegistrationStatus("REGISTERED");
		}else {
			dtls.setRegistrationStatus("UNREGISTERED");
		}
		return dtls;
	}
}