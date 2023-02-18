package designpattern.structural.ADproxy.cglib;


/**
 *         <dependency>
 *             <groupId>cglib</groupId>
 *             <artifactId>cglib</artifactId>
 *             <version>3.3.0</version>
 *         </dependency>
 */
public class CglibProxyTest {

    public static void main(String[] args) {

        //原来的对象都不用new
        LeiTikTok tikTok = new LeiTikTok();

        LeiTikTok proxy = CglibProxy.createProxy(tikTok);

        proxy.tiktokHaha();
    }
}
