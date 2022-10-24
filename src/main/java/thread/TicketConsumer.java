package thread;

import java.util.concurrent.TimeUnit;

class TicketConsumer implements Runnable {

	private volatile static Integer ticket = 10;

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + "开始抢第" + ticket + "张票，对象加锁之前：" + System.identityHashCode(ticket));
			synchronized (ticket) {
				System.out.println(Thread.currentThread().getName() + "抢到第" + ticket + "张票，成功锁到的对象：" + System.identityHashCode(ticket));
				if (ticket > 0) {
					try {
						//模拟抢票延迟
						TimeUnit.SECONDS.sleep(100000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票，票数减一");
				} else {
					return;
				}
			}
		}
	}
}
