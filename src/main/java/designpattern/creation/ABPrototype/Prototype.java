package designpattern.creation.ABPrototype;

/**
 * 能被复用的原型
 */
public class Prototype extends PrototypeAbstract {
    @Override
    public String toString() {
        return "PrototypeAbstract{" +
                "name='" + name + '\'' +
                '}';
    }
}
