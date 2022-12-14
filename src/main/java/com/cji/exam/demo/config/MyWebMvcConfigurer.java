package com.cji.exam.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cji.exam.demo.interceptor.BeforeActionInterceptor;
import com.cji.exam.demo.interceptor.NeedLoginIntercepor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	private BeforeActionInterceptor beforeActionInterceptor;
	private NeedLoginIntercepor needLoginIntercepor;
	
	@Autowired
	public MyWebMvcConfigurer(BeforeActionInterceptor beforeActionInterceptor, NeedLoginIntercepor needLoginIntercepor) {
		this.beforeActionInterceptor = beforeActionInterceptor;
		this.needLoginIntercepor = needLoginIntercepor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
				.excludePathPatterns("/error");
		registry.addInterceptor(needLoginIntercepor).addPathPatterns("/usr/article/write").addPathPatterns("/usr/article/doAdd").addPathPatterns("/usr/article/doDelete").addPathPatterns("/usr/article/modify").addPathPatterns("/usr/article/doModify");
	}

}
