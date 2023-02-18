package designpattern.structural.ABbridge;

/**
 * 线下渠道
 */
public class OfflineSale  extends AbstractSale{
    public OfflineSale(String type, Integer price) {
        super(type, price);
    }
}
