package notify;

public class Test {
    public static void main(String[] args) {
        Print print = new Print();

        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                print.printChar();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                print.printNum();
            }
        }).start();
    }
}