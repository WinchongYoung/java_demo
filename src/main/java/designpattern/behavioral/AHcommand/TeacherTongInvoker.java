package designpattern.behavioral.AHcommand;

/**
 * 命令调用者（发起者）
 *
 * Controller
 */
public class TeacherTongInvoker {
    Command command;

    public void call(){
        //命令
        command.execute();
    }


    public void setCommand(Command command) {
        this.command = command;
    }
}
