package collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class List2String {
    public static void main(String[] args) {
        // list转string,使用逗号分割
        // ① lambda
        List<Integer> integers = Arrays.asList(1, 2, 3);
        System.out.println(integers.stream().map(x -> x + "").collect(Collectors.joining(",")));

        // ②String join方法
        List<String> cities = Arrays.asList("Milan",
                "London",
                "New York",
                "San Francisco");
        String citiesCommaSeparated = String.join(",", cities);
        System.out.println(citiesCommaSeparated);
    }
}
