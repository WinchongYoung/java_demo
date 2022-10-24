package prox;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    /**
     * jdk动态代理会生成一个动态代理类，生成相应的字节码，然后通过ClassLoader加载字节码；
     * <p>
     * 该实例继承了Proxy类，并实现了业务接口，在实现的方法里通过反射调用了InvocationHandler接口实现类的invoke()回调方法；
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        OrderService orderService = new OrderServiceImpl();
        saveProxyFile();
        ServiceInvocationHandler handler = new ServiceInvocationHandler(orderService);
        // 根据目标生成代理对象
        OrderService proxy2 = (OrderService) handler.getProxy();
        proxy2.editOrder();
    }

    private static void saveProxyFile() {
        FileOutputStream out = null;
        try {
            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", UserServiceImpl.class.getInterfaces());
            out = new FileOutputStream("C:\\Users\\Yang\\Desktop\\IHandlerInterface" + "$Proxy0.class");
            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}