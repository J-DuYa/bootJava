package com.example.demo.dto;

import lombok.Data;

@Data
public class GirlDTO {

	private Integer id;
	
	private String cupSize;

	private Integer age;
	
	//可添加额外的数据，不会被加入到数据中
}
