package cn.liuhp.serial;

public class Person extends SubClassSerial {


    private static final long serialVersionUID = 6544363425399344466L;

    private String name;

    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name + ", value=" + getValue() +"}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
