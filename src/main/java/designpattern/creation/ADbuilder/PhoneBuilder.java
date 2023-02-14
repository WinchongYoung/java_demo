package designpattern.creation.ADbuilder;

public class PhoneBuilder extends AbstractBuilder {

    Phone phone;

    public PhoneBuilder() {
        phone = new Phone();
    }

    @Override
    PhoneBuilder setCPU(String cpu) {
        phone.cpu = cpu;
        return this;
    }

    @Override
    PhoneBuilder setMem(String mem) {
        phone.mem = mem;
        return this;
    }

    @Override
    PhoneBuilder setDisk(String disk) {
        phone.disk = disk;
        return this;
    }

    @Override
    public Phone build() {
        return phone;
    }
}
