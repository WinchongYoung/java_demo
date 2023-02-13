package designpattern.creation.ADbuilder;

abstract class Product {

    protected String cpu;

    protected String mem;

    protected String disk;

    abstract Product setCpu(String cpu);

    abstract Product setMem(String mem);

    abstract Product setDisk(String disk);
}
