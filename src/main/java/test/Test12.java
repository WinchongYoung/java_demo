package test;

public class Test12 {
    public static void main(String[] args) {
        // -123
        // -321
        System.out.println(test(0));
    }

    public static String test(int i) {
        String st = i + "";
        char[] chars = st.toCharArray();
        StringBuilder s = new StringBuilder();
        int start = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            s.append(chars[0]);
            start = 1;
        }
        for (int j = chars.length - 1; j >= start; j--) {
            s.append(chars[j]);
        }
        // System.out.println(s);
        return s.toString();
    }
}
