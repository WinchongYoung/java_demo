package designpattern.creation.ADbuilder;

public class Phone extends Product {

    protected String cpu;

    protected String mem;

    protected String disk;

    public String getCpu() {
        return cpu;
    }

    public String getMem() {
        return mem;
    }

    public String getDisk() {
        return disk;
    }

    public Phone setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public Phone setMem(String mem) {
        this.mem = mem;
        return this;
    }

    public Phone setDisk(String disk) {
        this.disk = disk;
        return this;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", mem='" + mem + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }
}
