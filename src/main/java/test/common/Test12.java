package test.common;

public class Test12 {
    public static void main(String[] args) {
        // -123
        // -321
        System.out.println(test(-123));
    }

    public static Integer test(int i) {
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
        return Integer.parseInt(s.toString());
    }
}
