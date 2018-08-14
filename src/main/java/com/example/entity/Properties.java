package com.example.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Properties {

	@Value("${com.test.name}")
	private String name;
	@Value("${com.test.title}")
	private String title;


}
