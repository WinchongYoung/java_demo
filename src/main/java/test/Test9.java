package test;

import java.util.Stack;

public class Test9 {
    public static void main(String[] args) {
        System.out.println(isValidStr("()"));
    }

    public static boolean isValidStr(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() == '(' && ch != ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
