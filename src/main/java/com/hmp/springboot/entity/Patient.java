package com.hmp.springboot.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Patient_Id;
	
	
	//@Column(name = "Patient_Name" , nullable=false)
	private String Patient_Name;

	//@Column(name = "gender", nullable=false)
	private String gender;

	//@Column(name = "Birthdate", nullable=false)
	private String Birthdate;

	//@Column(name = "BloodGroup", nullable=false)
	private String BloodGroup;

	//@Column(name = "MobileNo", nullable=false)
	private long MobileNo;

	//@Column(name = "city", nullable=false)
	private String city;

	//@Column(name = "Address", nullable=false)
	private String Address;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "DoctorId")
	@JsonIgnore
	private Doctor doctor;
	
	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Patient() {

	}

	
	public Patient( String patient_Name, String gender, String birthdate, String bloodGroup,
			long mobileNo, String city, String address) {
		super();
		
		Patient_Name = patient_Name;
		this.gender = gender;
		Birthdate = birthdate;
		BloodGroup = bloodGroup;
		MobileNo = mobileNo;
		this.city = city;
		Address = address;
	}


	public int getPatient_Id() {
		return Patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		Patient_Id = patient_Id;
	}

	public String getPatient_Name() {
		return Patient_Name;
	}

	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public long getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	

	


	@Override
	public String toString() {
		return "Patient [Patient_Id=" + Patient_Id + ", Patient_Name=" + Patient_Name + ", gender=" + gender
				+ ", Birthdate=" + Birthdate + ", BloodGroup=" + BloodGroup + ", MobileNo=" + MobileNo + ", city="
				+ city + ", Address=" + Address + "]";
	}



}
