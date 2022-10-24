package test;

public class Test4 {
	public synchronized void test() {
		// 阻塞卡死了
		abc();
	}

	public synchronized void abc() {
	}

	public static void main(String[] args) {
		new Test4().abc();
	}
}
