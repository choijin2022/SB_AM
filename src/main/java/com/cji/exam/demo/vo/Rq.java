package com.cji.exam.demo.vo;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cji.exam.demo.util.Utility;

import lombok.Getter;

public class Rq {
	@Getter
	private int loginedMemberId;
	private HttpServletRequest req;
	private HttpServletResponse resp;
	public Rq(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession httpSession = req.getSession();
		this.req=req;
		this.resp=resp;
		
		int loginedMemberId = 0;
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}
		
		this.loginedMemberId = loginedMemberId;
	}

	public void jsPrintHistoryBack(String msg) {
		resp.setContentType("text/html; charset=UTF-8;");
		print("<script>");
		if(Utility.empty(msg)) {
			print("alert('" + msg + "');");
		}
		print("historyBack");
		print("</script>");
		
		
		
	}
	private void print(String str) {
		try {
			resp.getWriter().append(str);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
