package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.GirlRepository;
import com.example.demo.util.Girl;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(16);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("BBBB");
		girlB.setAge(18);
		girlRepository.save(girlB);
		
	}
	
}
