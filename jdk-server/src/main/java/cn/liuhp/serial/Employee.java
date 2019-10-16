package cn.liuhp.serial;

import java.io.Serializable;

/*
*
* 要能够序列化需要实现Serializable接口
* */
public class Employee implements Serializable {

    private String name;

    private int id;

    transient private int salary;//序列化的时候不会处理保存该字段

    @Override
    public String toString() {
        return "Employee{name=" + name + ",id=" + id + ",salary=" + salary + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
