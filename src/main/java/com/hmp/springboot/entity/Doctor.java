package com.hmp.springboot.entity;



import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int DoctorId;

	private String DoctorName;
	
	private String Gender;
	
	@Email(message="Email is not valid!")
	public String emailID;
	
	private Long Mobile;
	
	private String Qualification;
	
	private String Specialization;
	
	private String City;
	
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String password;
	
	
	
	@OneToMany(mappedBy="doctor", cascade=CascadeType.MERGE)
	@JsonIgnore
	private List<Patient> patient;
	
	public Doctor() {
		
	}

	
	
	
	
	public Doctor(String doctorName, String gender, @Email(message = "Email is not valid!") String emailID, Long mobile,
			String qualification, String specialization, String city,
			@Size(min = 8, message = "Password length must be 8 and contain uppercase,lowercase,digits") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String password,
			List<Patient> patient) {
		super();
		DoctorName = doctorName;
		Gender = gender;
		this.emailID = emailID;
		Mobile = mobile;
		Qualification = qualification;
		Specialization = specialization;
		City = city;
		this.password = password;
		this.patient = patient;
	}





	public int getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(int doctorId) {
		DoctorId = doctorId;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	

	public String getEmailID() {
		return emailID;
	}





	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}





	public Long getMobile() {
		return Mobile;
	}

	public void setMobile(Long mobile) {
		Mobile = mobile;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	
	
	
	
	
	
	
	

}
