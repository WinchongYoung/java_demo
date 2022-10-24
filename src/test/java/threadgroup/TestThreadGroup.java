package threadgroup;

public class TestThreadGroup {
    public static void main(String[] args) {
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        ThreadGroup ptg = tg.getParent();
        System.out.println(ptg.getParent());
    }
}
