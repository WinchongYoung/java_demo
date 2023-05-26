package collect;

import java.util.concurrent.LinkedBlockingQueue;

public class TestLinkedBlockingQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> ints = new LinkedBlockingQueue<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.remove();
        System.out.println(ints);
    }
}
