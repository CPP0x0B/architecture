package me.fenglu.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.fenglu.model.User;
import me.fenglu.service.UserService;

@RequestMapping("/user/")
@Controller
public class UserController {
	
	@Inject
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/update.do",produces = "application/json; charset=UTF-8")
	public String update(HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = request.getParameter("id");
		User u = new User();
		u.setId(userId);
		u.setAge(20);
		try {
			userService.saveOrUpdate(u);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "删除成功";
	}
}
