package prox;

/**
 * 业务接口实现类
 *
 * @author Muscleape
 */
public class OrderServiceImpl implements OrderService {


    @Override
    public void addOrder() {
        System.out.println("新创建了一个订单。。。");
    }

    @Override
    public void editOrder() {
        System.out.println("编辑一个订单。。。");
    }
}