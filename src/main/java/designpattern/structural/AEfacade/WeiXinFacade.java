package designpattern.structural.AEfacade;

/**
 * 外观（Facade）模式又叫作门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式
 */
public class WeiXinFacade {

    Police police = new Police();
    Edu edu = new Edu();
    Social social = new Social();

    /**
     * 封装起来只留一个方法
     *
     * @param name
     */
    public void handleXxx(String name) {
        police.register(name);
        edu.assignSchool(name);
        social.handleSocial(name);
    }

    public void register(String name) {
        police.register(name);
    }

    public void assignSchool(String name) {
        edu.assignSchool(name);
    }

}
/**
 * 什么场景使用？
 * 去医院看病，可能要去挂号、门诊、划价、取药，让患者或患者家属觉得很复杂，如果有提供接待人员，只让接待人员来处理，就很方便。以此类比......
 * JAVA 的三层开发模式。
 * 分布式系统的网关
 * Tomcat源码中的RequestFacade干什么的？
 * ......
 */
