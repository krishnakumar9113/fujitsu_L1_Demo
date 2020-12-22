package com.fujitsu.L1.Pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import com.fujitsu.L1.CustomValidator.AgeConstraint;
import com.fujitsu.L1.CustomValidator.GenderConstraint;
import com.fujitsu.L1.CustomValidator.BloodGroupConstraint;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
    @GeneratedValue(generator = "eid_generator")
    @SequenceGenerator(
            name = "eid_generator",
            sequenceName = "id_sequence",
            initialValue = 1
    )
     @Column(name = "emp_id")
	private long emp_id;// (PK)				Int 	
	
	@Size(min = 1, max = 50 , message="Input between 1 to 50 characters!!")
	@Pattern(regexp="[a-zA-Z]*", message="Please input alphabet only!!")
	@Column(name = "first_name")
	private String first_name;//				Char ( 50)	
	
	 @Size(min = 1, max = 50,message="Input between 1 to 50 characters!")
	 @Pattern(regexp="[a-zA-Z]*", message="Please input alphabet only!")
	 @Column(name = "last_name")
	 private String last_name	;//			Char(50)	
	
	 @GenderConstraint
	 @Column(name = "gender")
	 private String gender;//			Char(2)	
	 
	 @Past(message="Date must be a Past Date")
	 @AgeConstraint
	 @Column(name = "dob")
	 @DateTimeFormat(pattern="dd/mm/yyyy")
	 private LocalDate dob;//				date	
	 
	 @Pattern(regexp="^[a-zA-Z0-9]*$", message="Please input alphanumeric only!")
	 @Size(min = 10, max = 10 , message="Please input 10 characters only!")
	 @Column(name = "pan_num")
	 private String pan_num;//			char(15)
	 
	 @Size(min = 12, max = 12 , message="Please input 12 numbers only!")
	 @Pattern(regexp="[0-9]+", message="Please input numeric only!")
	 @Column(name = "aadhaar_num")
	 private String aadhaar_num	;//			char(15)	
	 
	 @Size(min = 10, max = 10 , message="Please input 10 numbers only!")
	 @Pattern(regexp="[0-9]+", message="Please input numeric only!")
	 @Column(name = "mobile_num")
	 private String mobile_num;//				char(15)	
	 
	 @NotBlank
	 @Email (message="Please input a valid email!")
	
	 //@UniqueElements (message="Email id is already taken!")
	 @Column(name = "email_id",unique = true)
	 private String email_id;//			char(150)	
	 
	 @NotBlank
	 @Email (message="Please input a valid email!")
	// @UniqueElements (message="Email id is already taken!")
	
	 @Column(name = "office_mail",unique = true)
	 private String office_mail;//			char(150)	
	 
	 @Size(min = 0, max = 200 , message="Text should not exceeds 200 characters!")
	 @Column(name = "permanent_address")
	 private String permanent_address;//				text	
	 
	 @Size(min = 0, max = 200 , message="Text should not exceeds 200 characters!")
	 @Column(name = "present_address")
	 private String present_address	;//			text	
	 
	 @BloodGroupConstraint
	 @Column(name = "blood_group")
	 private String blood_group	;//			char(5)	
	 
	 @Column(name = "profile_pict")
	 private String profile_pict	;//			char(200)	
	 
	 @Column(name = "doj")
	 @DateTimeFormat(pattern="dd/mm/yyyy")
	 private LocalDate doj;//			date	
	 
	 @Digits(fraction=0, integer = 2,message="Please input numeric only! ")
	 @Range(min = 7l,max=13l, message = "Please select a value between 7 to 13!")
	// @Size(min = 7, max = 13 , message="Please select a value between 7 to 13!")
	 @Column(name = "emp_level")
	 private long emp_level;//			Int 	
	 
	 @Size(min = 1, max = 30 , message="Please input within 30 characters")
	 @Pattern(regexp="[a-zA-Z ]*$", message="Please input only alphabet and space")
	 @Column(name = "post_name")
	 private String post_name	;//			char(30)
	 
	// @Size(min = 3, max = 8 , message="Please input  between 3 to 8 characters!")
	// @Pattern(regexp="/([1-9][0-9]*)|0/", message="Please input numeric only!")
	// @Digits(fraction=0, integer = 8,message="Please input numeric only! ")
	// @NumberConstraint
	 @Range(min = 100l,max=99999999l, message = "Please input  between 3 to 8 characters!")
	 @Column(name = "basic_pay")
	 private long basic_pay;//			Int 	
	 
	// @Digits(fraction=0, integer = 5,message="Please input numeric only! ")
	 @Range(min = 100l,max=99999l, message = "Please input  between 3 to 5 characters!")
	// @NumberConstraint
	// @Pattern(regexp="/([1-9][0-9]*)|0/", message="Please input numeric only!")
	 @Column(name = "house_allowance")
	 private long house_allowance;//				Int 	
	
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPan_num() {
		return pan_num;
	}
	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}
	public String getAadhaar_num() {
		return aadhaar_num;
	}
	public void setAadhaar_num(String aadhaar_num) {
		this.aadhaar_num = aadhaar_num;
	}
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getOffice_mail() {
		return office_mail;
	}
	public void setOffice_mail(String office_mail) {
		this.office_mail = office_mail;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}
	public String getPresent_address() {
		return present_address;
	}
	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getProfile_pict() {
		return profile_pict;
	}
	public void setProfile_pict(String profile_pict) {
		this.profile_pict = profile_pict;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public long getEmp_level() {
		return emp_level;
	}
	public void setEmp_level(long emp_level) {
		this.emp_level = emp_level;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public long getBasic_pay() {
		return basic_pay;
	}
	public void setBasic_pay(long basic_pay) {
		this.basic_pay = basic_pay;
	}
	public long getHouse_allowance() {
		return house_allowance;
	}
	public void setHouse_allowance(long house_allowance) {
		this.house_allowance = house_allowance;
	}

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<EmployeeHistory>  emp_history;

	/*
	 * public List<EmployeeHistory> getEmp_history() { return emp_history; }
	 */
	public void setEmp_history(List<EmployeeHistory> emp_history) {
		this.emp_history = emp_history;
	}
	
	
	
}
