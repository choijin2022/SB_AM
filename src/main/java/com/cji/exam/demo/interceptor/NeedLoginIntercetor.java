package com.cji.exam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cji.exam.demo.vo.Rq;
@Component
public class NeedLoginIntercetor implements HandlerInterceptor {
	private Rq rq;
	
	@Autowired
	public NeedLoginIntercetor(Rq rq) {
		this.rq = rq;
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		
		
		req.setAttribute("rq", rq);
		if (rq.getLoginedMemberId() == 0) {
			rq.jsPrintHistoryBack("로그인 후 이용해주세요");
			return false;
		}
		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}

}
