package designpattern.creation.ADbuilder;

abstract class AbstractBuilder {

    abstract AbstractBuilder setCPU(String cpu);

    abstract AbstractBuilder setMem(String mem);

    abstract AbstractBuilder setDisk(String disk);

    public abstract Product build();
}
