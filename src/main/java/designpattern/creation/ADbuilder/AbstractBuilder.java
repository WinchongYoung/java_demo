package designpattern.creation.ADbuilder;

abstract class AbstractBuilder {

    Product product;

    abstract AbstractBuilder setCPU(String cpu);

    abstract AbstractBuilder setMem(String mem);

    abstract AbstractBuilder setDisk(String disk);

    Product build() {
        return product;
    }

}
