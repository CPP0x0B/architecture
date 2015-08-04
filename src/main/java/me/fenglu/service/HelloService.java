package me.fenglu.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.fenglu.model.User;
import me.fenglu.repository.HelloRepository;

@Service
public class HelloService {
	
	@Inject
	private HelloRepository helloRepository;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public void add(User u) throws Exception {
		helloRepository.add(u);
		System.out.println(u.getAge());
	}

	public User fetch(String id) {
		return helloRepository.fetch(id);
	}
	
}
