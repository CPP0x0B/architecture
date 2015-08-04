package me.fenglu.repository;

import javax.inject.Inject;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.fenglu.model.User;

@Repository
public class UserRepository {
	
	@Inject
	private HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly=false)
	public void saveOrUpdate(User u) throws Exception {
		hibernateTemplate.saveOrUpdate(u);
	}

}
