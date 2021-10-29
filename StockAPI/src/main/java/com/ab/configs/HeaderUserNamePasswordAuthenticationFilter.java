package com.ab.configs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class HeaderUserNamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	
	public HeaderUserNamePasswordAuthenticationFilter() {
		super();
		this.setFilterProcessesUrl("/**");
		this.setPostOnly(false);
	}
	
	@Override
	public String obtainPassword(HttpServletRequest request) {
		System.out.println(request);
//		return request.getHeader("password");
		return "";
	}
	
	@Override
	public String obtainUsername(HttpServletRequest request) {
		System.out.println(request);
//		return request.getHeader("username");
		return "";
	}
}
