package test.generic.interfacs;

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public interface Generator<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    public T next();
}