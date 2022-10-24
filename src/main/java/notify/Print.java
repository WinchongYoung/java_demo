package notify;

/**
 * 等待通知机制
 */
class Print {

    private int flag = 1;//信号量。当值为1时打印数字，当值为2时打印字母
    private int count = 1;

    public synchronized void printNum() {
        if (flag != 1) {
            //打印数字
            try {
                wait(); // 使调用该方法的线程释放共享资源锁，然后从运行状态退出，进入等待队列，直到被再次唤醒。
                        // wait使当前线程阻塞，前提是必须先获得锁，只能在synchronized锁范围内里使用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(2 * count - 1);
        System.out.print(2 * count);
        flag = 2;
        notify();
    }

    public synchronized void printChar() {
        if (flag != 2) {
            //打印字母
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char) (count - 1 + 'A'));
        count++;//当一轮循环打印完之后，计数器加1
        flag = 1;
        notify();
    }
}
