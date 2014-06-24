package com.templete.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class SecurityMetadataSource implements
FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
	private RequestMatcher pathMatcher;
	
	public SecurityMetadataSource() throws Exception {
		loadResourceDefine();
	}
	
	/**
	 * 加载所有权限与资源的关系
	 * @throws SystemRunException
	 */
	private void loadResourceDefine() throws Exception {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		Iterator<String> it = resourceMap.keySet().iterator();
		while (it.hasNext()) {
			String resURL = it.next();
//			Iterator<String> ite = resourceMap.keySet().iterator();
			pathMatcher = new AntPathRequestMatcher(resURL);
			if (pathMatcher.matches(((FilterInvocation) object).getRequest())) {
				Collection<ConfigAttribute> returnCollection = resourceMap
						.get(resURL);
				return returnCollection;
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
