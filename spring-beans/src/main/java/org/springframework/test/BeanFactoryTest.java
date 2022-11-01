package org.springframework.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class BeanFactoryTest {


	public static void main(String[] args) {
		testSimpleLoad();
//		getInputStream();
	}

	public static void getInputStream(){
		Resource resource = new ClassPathResource("beanFactoryTest.xml");

		try {
			/**
			 * @see org.springframework.core.io.ClassPathResource#getInputStream()
			 */
			InputStream inputStream = resource.getInputStream();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void testSimpleLoad(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));

		/**
		 * getBean方法的具体实现
		 * @see AbstractBeanFactory#doGetBean(java.lang.String, java.lang.Class, java.lang.Object[], boolean)
		 */
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		String str = myTestBean.getTestStr();

        System.out.println("result >>>> "+str);
    }

}
