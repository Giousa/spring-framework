package org.springframework.test.me;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicantContextTest {

	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("me-test.xml");
		Person person = (Person) act.getBean("person");
		System.out.println(person.toString());
	}
}
