package cn.liuhp.ioc.bean;

/**
 * @description: person bean
 * @author: liuhp534
 * @create: 2019-06-09 14:51
 */
public class Person {

    public String name;

    private Car car;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
