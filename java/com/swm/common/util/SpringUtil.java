package com.swm.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext context = null;

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		context = ctx;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	/**
	 * @param beanId
	 * @return
	 */
	public static Object getBean(String id) {
		try {
			return getContext().getBean(id);
		} catch (BeansException be) {
			be.printStackTrace();
			return null;
		}
	}
}
