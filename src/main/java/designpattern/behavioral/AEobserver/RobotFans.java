package designpattern.behavioral.AEobserver;

public class RobotFans extends AbstractFans {
    @Override
    void acceptMsg(String msg) {
        System.out.println("呸....");
    }
}
