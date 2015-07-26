package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import me.fenglu.interceptor.TimeBasedAccessInterceptor;

@EnableLoadTimeWeaving
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"me.fenglu.controller","me.fenglu.service","me.fenglu.repository"})
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setViewClass(JstlView.class);
		jspViewResolver.setPrefix("/WEB-INF/view/");
		jspViewResolver.setSuffix(".jsp");
		return jspViewResolver;
	}
	
	@Bean
	public RequestMappingHandlerMapping handlerMapping() {
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		List<Object> interceptors = new ArrayList<Object>();
		interceptors.add(interceptor());
		handlerMapping.setInterceptors(interceptors.toArray());
		return handlerMapping;
	}
	
	@Bean
	public TimeBasedAccessInterceptor interceptor() {
		TimeBasedAccessInterceptor interceptor = new TimeBasedAccessInterceptor();
		interceptor.setOpeningTime(0);
		interceptor.setClosingTime(24);
		return interceptor;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000);
		return multipartResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
	}
}
