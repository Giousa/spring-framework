package org.springframework.test.resolvabletype;

import java.util.List;

public class WrapperTest<T> {

	private String name;

	private List<Integer> ids;

	private List<? extends Number> names;

	private List<T> names2;
}
