package designpattern.structural.AAadapter.obj;


import designpattern.structural.AAadapter.Player;
import designpattern.structural.AAadapter.Translator;
import designpattern.structural.AAadapter.Zh_JPTranslator;

/**
 * 组合的方式：对象结构模型，适配转换到了翻译器的功能上
 * （继承、组合）、封装、多态
 */
public class JPMoviePlayerAdapter implements Player {

    // 组合的方式
    private final Translator translator = new Zh_JPTranslator();
    // 被适配对象
    private final Player target;

    public JPMoviePlayerAdapter(Player target) {
        this.target = target;
    }

    @Override
    public String play() {
        String play = target.play();
        //转换字幕
        String translate = translator.translate(play);
        System.out.println("日文：" + translate);
        return play;
    }
}
