package com.hellospring.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("val1", "val2", "val3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		
		return mappingfiltered(new MappingJacksonValue(someBean), filter);
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("val1", "val2", "val3"), new SomeBean("val4", "val5", "val6"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
	
		return mappingfiltered(new MappingJacksonValue(list), filter);
	}
	
	private MappingJacksonValue mappingfiltered(MappingJacksonValue mappingJacksonValue, 
			SimpleBeanPropertyFilter filter) {
		//Dinamic filter
		//Allow to defined filters -> SomeBeanFilter must be defined in the class
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
