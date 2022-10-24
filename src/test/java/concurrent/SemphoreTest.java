package concurrent;
 
import java.util.concurrent.Semaphore;
 
/**
 * java 信号量测试， 通常是多个线程争抢有限资源的情况下的使用
 */
public class SemphoreTest {
    public static void main(String[] args) {
        SemphoreTest st = new SemphoreTest();
        st.test();
    }
 
    private void test() {
        Semaphore sem = new Semaphore(3);
        for(int i = 1;i <= 5;i++)
        {
            new MyThread(sem, i).start();
        }
    }
 
    class MyThread extends Thread
    {
        private Semaphore sem;
        private int sec;
        MyThread(Semaphore sem, int sec)
        {
            this.sem = sem;
            this.sec = sec;
        }
 
        @Override
        public void run() {
            super.run();
            try {
                sem.acquire();
 
                System.out.println("thread " + sec + " start...");
                Thread.sleep(sec * 1000);
                System.out.println("thread " + sec + " end...");
 
                sem.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
            }
        }
    }
}