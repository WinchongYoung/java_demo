package designpattern.behavioral.AGinterpreter;

/**
 * 解释器模式
 */
public class InterpreterTest {

    public static void main(String[] args) {
        Area area = new Area();
        /**
         *  上海市：张文宏-医生
         *  武汉市:雷丰阳-程序员
         *  北京市：宋宋-老人
         */
        String sr = "武汉市:雷丰阳-程序员";
        area.getTicket(sr);
    }
}

/**
 * 什么场景用到？
 * Spring的表达式解析：#{}
 * Thymeleaf等模板引擎的语法解析
 * 编译原理
 * ......
 */
