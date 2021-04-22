package com.sumit.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping("/people")
	public People showPeople() {
		
		//(String name, Integer age, String occupation, String address, Integer phoneNumber)
		return new People("Sumit", 37, "Software Developer", "Dahisar East", 1234567890);
		
	}
	
	@GetMapping("/people-list")
	public List<People> showAll() {
		
		//(String name, Integer age, String occupation, String address, Integer phoneNumber)
		return Arrays.asList(new People("Sumit", 37, "Software Developer", "Dahisar East", 1234567890),
				new People("Sumit2", 38, "Software Developer Junior", "Dahisar East Mumbai", 1807654321));
		
	}
	
	@GetMapping("/people-list-filtered")
	public MappingJacksonValue showPeopleWithFilteredFields() {
		
		People people = new People("Sumit", 37, "Software Developer", "Dahisar East", 1234567890);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(people);
		SimpleBeanPropertyFilter beanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "occupation", "address");
		FilterProvider filters = new SimpleFilterProvider().addFilter("PeopleFilter", beanFilter );
		mappingJacksonValue.setFilters(filters);
		
		
		return mappingJacksonValue;
		
	}

}
