package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则
 */
public class RegexTest {
    public static void main(String[] args) {
        String jsonString = "{\"id\":\"123123\",\"name\":\"gaga\"}";
        String regex = "\"name\":\"(.*?)\\\"";
        Matcher matcher = Pattern.compile(regex).matcher(jsonString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
