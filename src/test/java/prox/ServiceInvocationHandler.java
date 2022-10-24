package prox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 构造函数
     *
     * @param target
     */
    public ServiceInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 实现InvocationHandler接口的方法
     * <p>
     * 执行目标对象的方法，并进行增强
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;
        System.out.println("事务开始。。。");
        // 执行目标方法对象
        result = method.invoke(target, args);
        System.out.println("事务结束。。。");
        return result;
    }

    /**
     * 创建代理实例
     *
     * @return
     * @throws Throwable
     */
    public Object getProxy() throws Throwable {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(), this);
    }

}
