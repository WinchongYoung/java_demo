package test.common;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String singleElement = "Hello";
        
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(singleElement));
        System.out.println(arrayList);
    }
}