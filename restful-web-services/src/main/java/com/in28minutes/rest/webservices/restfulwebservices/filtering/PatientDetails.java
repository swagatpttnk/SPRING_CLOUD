package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Class to demo attribute level filtering
public class PatientDetails {

	private String firstName;
	private String lastName;
	
	@JsonIgnore
	private String ssn;
	private String mbi;
	
	@JsonIgnore
	private String mpin;
	
	PatientDetails(){
		
	}
	
	PatientDetails(String firstName,String lastName,String ssn,String mbi,String mpin){
		this.firstName=firstName;
		this.lastName=lastName;
		this.ssn=ssn;
		this.mbi=mbi;
		this.mpin=mpin;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getMbi() {
		return mbi;
	}
	public void setMbi(String mbi) {
		this.mbi = mbi;
	}

	public String getMpin() {
		return mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	

}