package com.cji.exam.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
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
		
		InterceptorRegistration ir;
		ir = registry.addInterceptor(beforeActionInterceptor);
		ir.addPathPatterns("/**");
		ir.addPathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");
		ir.excludePathPatterns("/error");
		
		ir = registry.addInterceptor(needLoginIntercepor);
		ir.addPathPatterns("/usr/article/write");
		ir.addPathPatterns("/usr/article/doAdd");
		ir.addPathPatterns("/usr/article/doDelete");
		ir.addPathPatterns("/usr/article/modify");
		ir.addPathPatterns("/usr/article/doModify");
		ir.addPathPatterns("/usr/reactionPoint/doReactionPoint");
		ir.addPathPatterns("/usr/reactionPoint/delReactionPoint");
		ir.addPathPatterns("/usr/reply/doWrite");
		
		
	
	}

}
  