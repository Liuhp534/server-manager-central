package cn.liuhp.serial;

/*
* 为序列化的父类
* 可以序列化父类的状态，即便它没有实现序列化接口。当父类是一个我们无法改变的第三方的类，这个策略就有用武之地了。（子类实现序列化）
* */
public class SubClassNoSerial {


    private String value;

    @Override
    public String toString() {
        return "SubClassNoSerial{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
