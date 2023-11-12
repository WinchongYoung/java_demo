package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则
 */
public class RegexTest2 {
    public static void main(String[] args) {
        String json = "{\"id\": \"123\", \"name\": \"John\"}";
        // 例如要替换name属性的值
        String regex = "\"name\": \"[^\"]+\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);
        String newJson = matcher.replaceAll("\"name\": \"Mary\"");
        System.out.println(newJson);
    }

}
