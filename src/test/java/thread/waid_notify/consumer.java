package thread.waid_notify;

//生产者
class consumer implements Runnable {
    private Food food;
    int i = 20;

    consumer(Food food) {
        this.food = food;
    }

    public void consume() {
        try {
            synchronized (food) {
                while (food.isEmpty()) {
                    food.wait();
                }
                food.food_down();
                System.out.println("消费者" + Thread.currentThread().getName() + "正在消费 1个食物，目前食物剩余量" + food.getCount());
                food.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (i-- >= 0) {
            consume();
        }
    }
}