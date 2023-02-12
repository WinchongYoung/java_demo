package designpattern.creation.ABPrototype;

/**
 * 能被复用原型的抽象类
 */
public abstract class PrototypeAbstract implements Cloneable {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "PrototypeAbstract{" +
                "name='" + name + '\'' +
                '}';
    }
}
