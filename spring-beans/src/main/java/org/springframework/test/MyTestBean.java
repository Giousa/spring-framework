package org.springframework.test;

import org.springframework.beans.factory.annotation.Autowired;

public class MyTestBean {

	@Autowired
	private StudentBean studentBean;

    private String testStr = "this is MyTestBean";

    public String getTestStr() {
        return testStr;
    }

	public void execStudentFun(){
		studentBean.study();
	}

	public void func(){
		System.out.println("MyTestBean  func  方法执行了.");
	}

}
