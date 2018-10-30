package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class PatientDetailsController {
	
	@GetMapping(path = "/patient/filter")
	public PatientDetails getPatientDetails() {
		return new PatientDetails("Den","Lunar","SSN1234512345","MBI12345","MPIN1234");
	}

	@GetMapping(path = "/patient/filter-list")
	public List<PatientDetails> getPatientDetailsList() {
		return Arrays.asList(new PatientDetails("Den","Lunar","SSN1234512345","MBI12345","MPIN1234"),
				new PatientDetails("John","Senat","SSN8765429","MBI782354","MPIN4567")
				);
	}
	
	@GetMapping(path = "/patient/filter2")
	public PatientDetails2 getPatientDetails2() {
		return new PatientDetails2("Den","Lunar","SSN1234512345","MBI12345","MPIN1234");
	}

	@GetMapping(path = "/patient/filter2-list")
	public List<PatientDetails2> getPatientDetailsList2() {
		return Arrays.asList(new PatientDetails2("Den","Lunar","SSN1234512345","MBI12345","MPIN1234"),
				new PatientDetails2("John","Senat","SSN8765429","MBI782354","MPIN4567")
				);
	}

}