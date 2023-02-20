package designpattern.structural.AEfacade;


/**
 * 需求：来回跑太麻烦，按照最少知道原则，我就想和一个部门进行交互。
 */
public class FacadeTest {
    public static void main(String[] args) {
        WeiXinFacade facade = new WeiXinFacade();
        facade.handleXxx("雷丰阳");
    }
}
