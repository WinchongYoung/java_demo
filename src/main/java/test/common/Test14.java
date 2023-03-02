package test.common;

import java.io.File;

public class Test14 {
    public static void main(String[] args) {
        File file = new File(".\\haha\\gaga");
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
