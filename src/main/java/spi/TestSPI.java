package spi;

import java.util.ServiceLoader;

/**
 * spi机制
 * 1、在src\main\resources\META-INF\services目录中新建已接口全名为名字的文档
 * 2、在文档中写接口的实现类全名
 * 3、调用ServiceLoader.load方法获取
 */
public class TestSPI {
    public static void main(String[] args) {
        ServiceLoader<Search> clazz = ServiceLoader.load(Search.class);
        for (Search search : clazz) {
            System.out.println(search.search());
        }
    }
}
