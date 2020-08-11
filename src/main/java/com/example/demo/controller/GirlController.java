package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import com.example.demo.util.Girl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultUtil;

@RestController
public class GirlController {
	
	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	@GetMapping(value = "/girlsList")
	public List<Girl> girlList() {
		logger.info("girlsList");
		return girlRepository.findAll();
	}
	
	//添加女生
	@PostMapping(value = "/addGirls")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		
		return ResultUtil.success(girlRepository.save(girl));
	}
	
	//更新
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpadate(@PathVariable("id") Integer id,
			@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		return girlRepository.save(girl);
	}
	
	//删除
	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.deleteById(id);
	}
	
	@GetMapping(value = "/girls/{id}")
	public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findById(id);
	}
	
	//通过年龄查询女生列表
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}
	
	//通过罩杯查询女生列表
	@GetMapping(value = "/girls/cupSize/{cupSize}")
	public List<Girl> girlListByCupSize(@PathVariable("cupSize") String cupSize) {
		return girlRepository.findByCupSize(cupSize);
	}
	
	@PostMapping(value = "/girls/two")
	public void girlTwo() {
		girlService.insertTwo();
	}
	
}
