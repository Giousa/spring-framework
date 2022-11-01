package org.springframework.test;

public class StudentBean {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void study(){
		System.out.println(this.name+": 正在学习中...");
	}

	@Override
	public String toString() {
		return "StudentBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
