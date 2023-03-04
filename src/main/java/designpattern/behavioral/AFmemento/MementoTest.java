package designpattern.behavioral.AFmemento;


/**
 * 1、备忘录的设计（提取属性）
 * 2、备忘录对象和原对象的互转操作（BeanUtils属性对拷）
 * 序列化
 * 保存数据库
 */
public class MementoTest {

    public static void main(String[] args) throws Exception {

        LeiGamer leiGamer = new LeiGamer();

        leiGamer.playGame();

        //第一次保存
        leiGamer.saveGameRecord();

        leiGamer.playGame();

        leiGamer.playGame();

        leiGamer.saveGameRecord();


        LeiGamer fromMemento = leiGamer.getFromMemento(1);

        fromMemento.playGame();


    }
}
/**
 * 什么场景用到？
 * 游戏存档
 * 数据库保存点事务（savepoint）
 * session活化钝化
 * ......
 */
