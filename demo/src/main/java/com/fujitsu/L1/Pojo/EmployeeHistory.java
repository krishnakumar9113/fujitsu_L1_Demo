package com.fujitsu.L1.Pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employment_history")
public class EmployeeHistory {
	@Id
    @GeneratedValue(generator = "emp_hist_id_generator")
    @SequenceGenerator(
            name = "emp_hist_id_generator",
            sequenceName = "id_sequence",
            initialValue = 1
    )
	@Column(name = "id")
	private long id;// (PK)				Int 	
	  //@Column(name = "emp_id")
	//private long emp_id ;//(FK)				Int 	
	  @Column(name = "organization_name")
	  private String organization_name;//				Int 	
	  @Column(name = "from_date")
	private LocalDate from_date	;//			date	
	  @Column(name = "until_date")
	private LocalDate until_date	;//			date	
	  @Column(name = "location")
	private String location	;//			chart(30)	
	  @Column(name = "country")
	private String country		;//		text	
	  @Column(name = "post")
	private String post		;//		chart(30)	
	  @Column(name = "skill_used")
	private String skill_used	;//			text	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
/*	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	*/
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public LocalDate getFrom_date() {
		return from_date;
	}
	public void setFrom_date(LocalDate from_date) {
		this.from_date = from_date;
	}
	public LocalDate getUntil_date() {
		return until_date;
	}
	public void setUntil_date(LocalDate until_date) {
		this.until_date = until_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSkill_used() {
		return skill_used;
	}
	public void setSkill_used(String skill_used) {
		this.skill_used = skill_used;
	}
	  

			@ManyToOne
            @JoinColumn(name = "emp_id")
            private Employee employee;

			/*
			 * public Employee getEmployee() { return employee; }
			 */
			public void setEmployee(Employee employee) {
				this.employee = employee;
			}
 

}
