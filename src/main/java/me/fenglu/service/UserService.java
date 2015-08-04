package me.fenglu.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.fenglu.model.User;
import me.fenglu.repository.UserRepository;

@Service
public class UserService {
	
	@Inject
	private UserRepository userRepository;
	
	public void saveOrUpdate(User u) throws Exception {
		userRepository.saveOrUpdate(u);
		u.setAge(19);
		userRepository.saveOrUpdate(u);
	}
	
}
