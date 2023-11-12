package enumTest;

public class EnumTest2 {
    enum Color {
        RED, GREEN, BLUE
    }

    public static void main(String[] args) {
        Color color1 = Color.RED;
        Color color2 = Color.GREEN;
        Color color3 = Color.RED;

        System.out.println(color1 == color2); // false
        System.out.println(color1 == color3); // true
    }
}
