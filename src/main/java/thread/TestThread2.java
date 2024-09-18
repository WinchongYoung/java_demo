package thread;

public class TestThread2 {

    public static Integer i = 1;
    public static void main(String[] args) throws InterruptedException {

        Thread why = new Thread(() -> i = 2);

        why.start();
        why.join();

        System.out.println(i);
    }
}
