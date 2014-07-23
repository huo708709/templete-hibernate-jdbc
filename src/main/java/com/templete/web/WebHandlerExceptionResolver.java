package com.templete.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class WebHandlerExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex) {

		//记录异常日志
		Logger logger = Logger.getRootLogger();
		logger.error(ex.getMessage(),ex);
		
		return super.doResolveException(request, response, object, ex);
	}
	
}
