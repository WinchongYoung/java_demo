package designpattern.behavioral.ABstrategy;

/**
 * 冲锋向前策略
 */
public class UziStrategy implements GameStrategy{
    @Override
    public void warStrategy() {
        System.out.println("uzi.....");
    }
}
