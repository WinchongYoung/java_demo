package thread;

public class PrintString implements Runnable {
	private boolean isRunnning = true;

	@Override
	public void run() {
		System.out.println("Thread begin: " + Thread.currentThread().getName());
		while (isRunnning == true) {
		}
		System.out.println("Thread end: " + Thread.currentThread().getName());
	}

	public boolean isRunnning() {
		return isRunnning;
	}

	public void setRunnning(boolean runnning) {
		isRunnning = runnning;
	}

	public static void main(String[] args) throws InterruptedException {
		PrintString printString = new PrintString();
		Thread thread = new Thread(printString, "Thread-A");
		thread.start();
		Thread.sleep(1000);
        printString.setRunnning(false);
		System.out.println("我要停止它！" + Thread.currentThread().getName());
	}
}