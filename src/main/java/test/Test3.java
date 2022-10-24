package test;

import com.google.common.collect.Lists;

import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = null;
		Boolean flag = false;
		// a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
		Integer result = (flag ? a * b : c);
	}

}
