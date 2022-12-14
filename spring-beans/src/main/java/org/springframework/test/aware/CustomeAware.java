package org.springframework.test.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.test.MyTestBean;

public class CustomeAware implements BeanFactoryAware {

	private BeanFactory beanFactory;
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public void execTest(){
		MyTestBean myTestBean = (MyTestBean)beanFactory.getBean("myTestBean");
		myTestBean.func();
	}
}
