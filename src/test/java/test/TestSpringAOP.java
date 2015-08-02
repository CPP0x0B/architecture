package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfigMain;
import config.MvcConfig;
import me.fenglu.service.HelloService;

public class TestSpringAOP {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(new Class[] {AppConfigMain.class});
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		helloService.test();
	}
}
