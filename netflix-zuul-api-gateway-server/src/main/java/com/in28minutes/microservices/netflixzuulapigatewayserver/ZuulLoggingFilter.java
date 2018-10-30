package com.in28minutes.microservices.netflixzuulapigatewayserver;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
		// Filter task goes here
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		logger.info("Filter logic:request -> {} request uri -> {}", 
				request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		/* Evaluate condition on which this filter should be invoked.
		 * In this example the filter should be invoked if there is a non null value
		 * for request parameter SKIP_AUTHENTICATION
		 */
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		 
				 if(null!=request.getParameter("SKIP_AUTHENTICATION")) {
					return true; 
				 }else {
					 return false;// do authentication 
				 }
		
	}

	@Override
	public int filterOrder() {
		// Order of execution
		return 0;
	}

	@Override
	public String filterType() {
		// type: pre/post/error/all
		return "pre";
	}

}
