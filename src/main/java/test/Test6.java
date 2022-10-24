package test;

public class Test6 {
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Test6) super.clone();
    }
}
