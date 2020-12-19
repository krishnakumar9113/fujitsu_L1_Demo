package com.fujitsu.L1.Pojo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@Size(min = 1, max = 50)
	@Pattern(regexp="[a-zA-Z]*", message="the name can only contain letters")
	 @Column(name = "first_name")
	private String first_name;//				Char ( 50)	
	 @Column(name = "last_name")
	 private String last_name	;//			Char(50)	
	 @Column(name = "gender")
	 private String gender;//			Char(2)	
	 @Column(name = "dob")
	 private LocalDateTime dob;//				date	
	 @Column(name = "pan_num")
	 private String pan_num;//			char(15)	
	 @Column(name = "aadhaar_num")
	 private String aadhaar_num	;//			char(15)	
	 @Column(name = "mobile_num")
	 private String mobile_num;//				char(15)	
	 @Column(name = "email_id")
	 private String email_id;//			char(150)	
	 @Column(name = "office_mail")
	 private String office_mail;//			char(150)	
	 @Column(name = "permanent_address")
	 private String permanent_address;//				text	
	 @Column(name = "present_address")
	 private String present_address	;//			text	
	 @Column(name = "blood_group")
	 private String blood_group	;//			char(5)	
	 @Column(name = "profile_pict")
	 private String profile_pict	;//			char(200)	
	 @Column(name = "doj")
	 private LocalDateTime doj;//			date	
	 @Column(name = "emp_level")
	 private long emp_level;//			Int 	
	 @Column(name = "post_name")
	 private String post_name	;//			char(30)	
	 @Column(name = "basic_pay")
	 private long basic_pay;//			Int 	
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
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
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
	public LocalDateTime getDoj() {
		return doj;
	}
	public void setDoj(LocalDateTime doj) {
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
