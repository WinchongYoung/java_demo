package test.generic;

public class CommonClass {
    public <T> T getT(T t) {
        return t;
    }

    public static void main(String[] args) {
        new CommonClass().getT("Haha");
    }
}
