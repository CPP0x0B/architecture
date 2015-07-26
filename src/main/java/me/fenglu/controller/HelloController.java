package me.fenglu.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.fenglu.model.Student;
import me.fenglu.model.User;
import me.fenglu.service.HelloService;

@Controller
@RequestMapping("/hello/")
public class HelloController {
	
	@Inject
	private HelloService helloService;
	
	@RequestMapping("/hello.do")
	@ModelAttribute
	public void hello(@RequestParam String username, Model model) {
		helloService.test();
		User u = new User();
		u.setUsername(username);
		Student s = new Student();
		s.setUsername("123");
		model.addAttribute(u);
		model.addAttribute(s);
	}
}
