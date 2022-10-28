package org.springframework.test.resolvabletype;


import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResolvableTypeTest {

	public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
		/** ResolvableType 实际是对 java.lang.reflect.Type 类的包装，并且提供了访问下面方法。官方介绍如下：
		 *   Encapsulates a Java {@link java.lang.reflect.Type}, providing access to
		 *   {@link #getSuperType() supertypes}, {@link #getInterfaces() interfaces}, and
		 *   {@link #getGeneric(int...) generic parameters} along with the ability to ultimately
		 *   {@link #resolve() resolve} to a {@link java.lang.Class}.
		 */

		// 1. 类测试
		ResolvableType resolvableType = ResolvableType.forClass(IInterface1.class);
		// 获取接口
		ResolvableType[] interfaces = resolvableType.getInterfaces();
		// 获取泛型
		ResolvableType[] generics = resolvableType.getGenerics();
		ResolvableType generic = resolvableType.getGeneric(1);
		// 获取父类
		ResolvableType superType = resolvableType.getSuperType();

		// 2. 属性测试
		// 获取字段属性
		ResolvableType field = ResolvableType.forField(IInterface1.class.getDeclaredField("CACHE"));
		// 获取其父类 AbstractMap<List<String>, List<Integer>>
		ResolvableType superType1 = field.getSuperType();
		/* 将其类型转为map，
		 * 实际这样解析结果等价于 private Map<List<String>, List<Integer>> CACHE = new HashMap<>(); 的解析结果
		 * asMap 内部调用的 as(Map.class), 所以下面两个等价。 as 内部实际是获取其接口或者父类对象。 同理还有 asCollection() 方法， asCollection() 调用as(Collection.class)
		 */
		ResolvableType fieldMap1 = field.asMap();
		ResolvableType fieldMap2 = field.as(Map.class);
		// 获取泛型相关
		Class<?> resolve = field.getGenerics()[0].resolve(); // List<String>
		Class<?> resolve1 = field.getGenerics()[0].getGeneric(0).resolve(); // String
		// 递归获取泛型， 可以理解为获取指定层级的泛型类型
		Class<?> aClass = field.resolveGeneric(1, 0); // Integer (获取List<Integer>的Integer)

		// 3. 方法测试
		Method method = IInterface1.class.getMethod("generateList", List.class);
		// forMethodParameter 方法获取方法相关参数。
		// MethodParameter(method, paramIndex) 是将方法以及参数下标进行包装，下标意义： -1 获取方法返回值，0是第一个参数，1是第二个参数
		MethodParameter methodParameter = new MethodParameter(method, 0);
		ResolvableType resolvableType1 = ResolvableType.forMethodParameter(methodParameter);
		// 获取方法返回值相关描述
		ResolvableType returnType = ResolvableType.forMethodReturnType(method);
		ResolvableType returnType1 = ResolvableType.forMethodParameter(new MethodParameter(method, -1));
	}

	private interface Interface1<T, E> {
		List<T> generateList(List<E> e);
	}

	private interface Interface2<T, E> {
		List<T> generateList2(List<E> e);
	}

	private static class IInterface1<T> implements Interface1<Integer, String>, Interface2<Integer, String> {

		/**
		 * 模拟缓存 (这种写法实际是测试转换，实际一般会直接前面用Map 接参数)
		 */
		private HashMap<List<String>, List<Integer>> CACHE = new HashMap<>();

		@Override
		public List<Integer> generateList(List<String> e) {
			List<Integer> integers = CACHE.get(e);
			if (integers == null) {

			}
			return null;
		}

		@Override
		public List<Integer> generateList2(List<String> e) {
			return null;
		}

		public T getParam() {
			return null;
		}
	}

}