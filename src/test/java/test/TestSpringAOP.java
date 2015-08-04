package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfigMain;
import me.fenglu.model.User;
import me.fenglu.service.HelloService;

public class TestSpringAOP {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(new Class[] {AppConfigMain.class});
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		User u = new User();
		u.setAge(19);
		u.setBirthday(new Date());
		u.setSex(1);
		String b = "C++";
		u.setBlobField(b.getBytes());
		u.setClobField(b.toCharArray());
		helloService.add(u);
		
		User user1 = helloService.fetch(u.getId());
		
		System.out.println("===========================");
		System.out.println("==========="+new String(user1.getBlobField()));
	}
}
