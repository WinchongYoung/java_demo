package designpattern.creation.ADbuilder;

public class PhoneBuilder extends AbstractBuilder {

    public PhoneBuilder() {
        product = new Phone();
    }

    @Override
    AbstractBuilder setCPU(String cpu) {
        product.cpu = cpu;
        return this;
    }

    @Override
    AbstractBuilder setMem(String mem) {
        product.mem = mem;
        return this;
    }

    @Override
    AbstractBuilder setDisk(String disk) {
        product.disk = disk;
        return this;
    }
}
