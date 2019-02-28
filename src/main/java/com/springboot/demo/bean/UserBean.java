package com.springboot.demo.bean;


import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user.")	//Step22 - Section 3, Lecture 34
public class UserBean {

	@ApiModelProperty(hidden = true) //Step22 - Section 3, Lecture 34
	private Integer userId;
	
	@Size(min=2, max=10, message="firstname should have atleast 2 characters")
	@ApiModelProperty(notes = "Firstname must contain atleast 2 characters.") //Step22 - Section 3, Lecture 34
	private String firstname;
	
	@Size(min=2, max=10, message="lastname should have atleast 2 characters")
	@ApiModelProperty(notes = "Lastname must contain atleast 2 characters.") //Step22 - Section 3, Lecture 34
	private String lastname;
	
	@Past(message="Birth date is invalid")
	@ApiModelProperty(notes = "Birth date should be in the past.") //Step22 - Section 3, Lecture 34
	private Date dob;
	
	protected UserBean() {
		
	}
	public UserBean(Integer userId, String firstname, String lastname, Date dob) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "User details: \n Id: " + userId + ", firstname: " + firstname + ", lastname: " + lastname + ", DOB: " + dob;
		
	}
}
