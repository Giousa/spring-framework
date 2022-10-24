package org.springframework.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {


	public static void main(String[] args) {
		testSimpleLoad();
	}

    public static void testSimpleLoad(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));

        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");

        String str = myTestBean.getTestStr();

        System.out.println("result >>>> "+str);
    }

}
