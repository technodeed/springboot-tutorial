package com.springboot.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springboot.demo.bean.SampleBean;

/**
 * 
 * @author smanne02
 * 
 * Ref: Step25 - Section 3, Lecture 37 -> Implementing Dynamic Filtering for RESTful Service
 * 
 */
@RestController
@RequestMapping(path = "/test")
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSampleBean() {
		System.out.println("In " + FilteringController.class.getName() + "retrieveSampleBean() ***");
		SampleBean sampleBean = new SampleBean("Val1", "Val2", "Val3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("sampleBean", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(sampleBean);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveSampleBeanList() {
		System.out.println("In " + FilteringController.class.getName() + "retrieveSampleBeanList() ***");
		List<SampleBean> sampleBeanList = Arrays.asList(new SampleBean("Val-11", "Val-12", "Val-13"), 
				new SampleBean("Val-21", "Val-22", "Val-23"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("sampleBean", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(sampleBeanList);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}
}
