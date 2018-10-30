package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//Controller :to demo Dynamic level filtering
@RestController
public class DynamicFilterController {

	// field1,field2
	@GetMapping("/patient/dynamicfilter")
	public MappingJacksonValue retrieveSomeBean() {
		PatientDetails3 patientBean = new PatientDetails3("Swagger","delta","SSN1234512345","MBI12345","MPIN1234");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName","mbi");

		FilterProvider filters = new SimpleFilterProvider().addFilter("XYZBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(patientBean);

		mapping.setFilters(filters);

		return mapping;
	}

	// field2, field3
	@GetMapping("/patient/dynamicfilter-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		List<PatientDetails3> list = Arrays.asList(new PatientDetails3("Den","Lunar","SSN1234512345","MBI12345","MPIN1234"),
				new PatientDetails3("John","Senat","SSN8765429","MBI782354","MPIN4567"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");

		FilterProvider filters = new SimpleFilterProvider().addFilter("XYZBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		mapping.setFilters(filters);

		return mapping;
	}

}