package test.common;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class Test23 {
    public static void main(String[] args) {
        List<String> f = Arrays.asList("goodMorning", "fuckYou");
        List<String> strings = fieldsCamelToSnack(f);
        strings.forEach(System.out::println);
    }

    public static String camelToSnakeCase(String input) {
        StringBuilder result = new StringBuilder();
        if (input == null || input.isEmpty()) {
            return "";
        }
        // 第一个字符直接添加到结果中
        result.append(Character.toLowerCase(input.charAt(0)));
        // 遍历字符串的每个字符
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            // 如果当前字符是大写字母，则在结果中添加下划线并将其转换为小写字母
            if (Character.isUpperCase(currentChar)) {
                result.append("_").append(Character.toLowerCase(currentChar));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    static List<String> fieldsCamelToSnack(List<String> fields) {
        List<String> newFields = Lists.newArrayList();
        String[] re = fields.toArray(new String[0]);
        for (String s : re) {
            newFields.add(camelToSnakeCase(s));
        }
        return newFields;
    }
}
