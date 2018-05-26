package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.util.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

	List<Girl> findAll();
	
	//通过年龄查询
	public List<Girl> findByAge(Integer age);
	
	//通过罩杯查询女生列表
	public List<Girl> findByCupSize(String cupSize);

}
