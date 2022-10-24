package thread;

public class TestThread {
	public static void main(String[] args) {
		Thread why = new Thread(new TicketConsumer(), "why");
		Thread mx = new Thread(new TicketConsumer(), "mx");
		why.start();
		mx.start();
	}
}
