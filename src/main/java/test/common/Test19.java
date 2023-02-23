package test.common;

import java.util.ArrayList;
import java.util.List;

public class Test19 {
    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        list.add(2);
    }
}
