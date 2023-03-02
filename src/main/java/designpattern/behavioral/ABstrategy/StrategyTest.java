package designpattern.behavioral.ABstrategy;

public class StrategyTest {

    public static void main(String[] args) {
        TeamGNR gnr = new TeamGNR();
        // 传入策略类
        gnr.setGameStrategy(new RandomStrategy());
        gnr.startGame();
    }
}
/**
 * 什么场景用到？
 * 使用策略模式可以避免使用多重条件语句，如 if...else 语句、switch...case 语句
 * 什么是Spring的 InstantiationStrategy
 * 线程池拒绝策略
 */