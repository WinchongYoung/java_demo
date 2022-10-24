package thread.waid_notify;

//消费者
class producer implements Runnable {
    private Food food;
    int i = 20;

    producer(Food food) {
        this.food = food;
    }

    public void produce() {
        try {
            synchronized (food) { //注意此处上锁的对象！不是this！因为this是给当前这个线程对象上锁！而不是给目标资源food上锁！如果用的是this，那么谁来唤醒这个线程呢？没有其他线程拥有这个线程对象的锁，因而也就没线程唤醒，最终导致所有线程饿死！
                while (food.isFull()) {
                    food.wait();
                }
                food.food_up();
                System.out.println("生产者" + Thread.currentThread().getName() + "正在生产 1个食物，目前食物剩余量" + food.getCount());
                food.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (i-- >= 0) {
            produce();
        }
    }
}