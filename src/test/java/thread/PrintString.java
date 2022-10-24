package thread;

public class PrintString implements Runnable {

    // 在多线程中，多个线程访问主存中的临界资源（共享变量）时，需要首先从主存中拷贝一份共享变量的值到自己的工作内存中，
    // 然后在线程中每次访问该变量时都是访问的线程工作内存（高速缓存）中的共享的变量副本，
    // 而不是每次都去主存读取共享变量的值（因为CPU的读写速率和主存读写速率相差很大，
    // 如果CPU每次都访问主存的话那么效率会非常低）。
    // java线程变量加载的大致流程是，将主内存的变量加载到工作内存进行处理，处理完毕后写会主内存。
    // 工作内存什么时候同步主内存的变量：
    //   ①线程中释放锁，线程自己同步主存变量。
    //   ②当前线程释放锁后，当前线程会去加载主存变量。
    //   ③线程上下文切换。
    //   ④CPU有空闲时间时（比如线程休眠、IO操作等）
    // 参考：https://blog.csdn.net/tianzhonghaoqing/article/details/124690987

    // private volatile boolean isRunning = true;
    private boolean isRunning = true;

    @Override
    public void run() {
        System.out.println("Thread begin: " + Thread.currentThread().getName());
        int count = 0;
        while (isRunning) {
            // 当进行IO操作或者线程内部调用synchronized修饰的方法或者同步代码块时，线程的缓存会进行刷新，
            // 也就是会感知到共享变量的变化。当然这也只是针对非volatile修饰的变量而言，当变量被申明为volatile的时候，
            // 每次使用该变量都会从主内存中进行读取。故以下三种方法都能跳出循环
            // 参考：https://juejin.cn/post/6844903749933072392
            // ①System.out.println(isRunning);
            // ②System.out.print(6);
            /* ③synchronized (this) {
            }*/
        }
        System.out.println("Thread end: " + Thread.currentThread().getName());
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean Running) {
        isRunning = Running;
    }

    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        Thread thread = new Thread(printString, "Thread-A");
        thread.start();
        Thread.sleep(1000);
        printString.setRunning(false);
        System.out.println("我要停止它！" + Thread.currentThread().getName());
    }

}