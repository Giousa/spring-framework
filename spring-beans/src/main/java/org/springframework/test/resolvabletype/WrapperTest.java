package org.springframework.test.resolvabletype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperTest<T> {

	private String name;

	private List<Integer> ids;

	private List<? extends Number> names;

	private List<T> names2;

	public static List<String> test01(List<Integer> datas, Map<String, Object> map, String s, WrapperTest wrapper, String[] strs, int[] ints) throws NoSuchMethodException {
		System.out.println("执行了test01方法");

		List<String> list = new ArrayList<>();
		list.add("这个是测试");
		list.add("你好呀");
		return list;
	}
}
