package concurrent.future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread t1 = new ColdDishThread();
        Thread t2 = new BumThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间：" + (end - start));
    }
}
