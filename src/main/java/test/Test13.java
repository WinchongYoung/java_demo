package test;

public class Test13 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("-123");
        sb.append("123");
        int i = Integer.parseInt(sb.toString());
        System.out.println(i);

        // 获取处理器位数
        // 底层封装System.getProperty方法
        Integer javaVersion = Integer.getInteger("sun.arch.data.model");
        System.out.println(javaVersion);
        System.out.println(System.getProperty("sun.arch.data.model"));
    }
}
