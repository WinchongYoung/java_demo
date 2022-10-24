package thread.waid_notify;

//资源
class Food {
    private int count; //当前食物总量
    private final int MAX_COUNT = 5; //最大食物量

    Food(int count) {
        this.count = count;
    }

    //减少食物
    public void food_down() {
        if (!isEmpty()) {
            count--;
        }

    }

    //添加食物
    public void food_up() {
        if (!isFull()) {
            count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    //食物满了吗
    public boolean isFull() {
        return count == MAX_COUNT;
    }

    //食物空着吗？
    public boolean isEmpty() {
        return count == 0;
    }
}