package com.example.demo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class GirlDTO {

	private Integer id;
	
	private String cupSize;

	private Integer age;
	
	//可添加额外的数据，不会被加入到数据中	
	
}
