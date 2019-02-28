package com.springboot.demo.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter(value = "sampleBean")
public class SampleBean {

	private String field1;
	private String field2;
	private String field3;
	
	public SampleBean() {
		
	}
	public SampleBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	/**
	 * @return the field1
	 */
	public String getField1() {
		return field1;
	}
	/**
	 * @return the field2
	 */
	public String getField2() {
		return field2;
	}
	/**
	 * @return the field3
	 */
	public String getField3() {
		return field3;
	}
	
}
