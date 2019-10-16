package cn.liuhp.serial;

import java.io.Serializable;

/*
 *
 * 要能够序列化需要实现Serializable接口
 * */
public class Employee implements Serializable {

    //这个值的作用仅仅是告知反序列化处理机制，新的类是相同的类的新版本，应该进行可能的反序列化处理
    private static final long serialVersionUID = 5026275996690139003L;


    private String name;

    private int id;

    transient private int salary;//序列化的时候不会处理保存该字段，经过实践的确不会序列化

    private static int age;//静态变量的值也不会被序列化，因为他们是属于类而非对象的，经过实践的确不会序列化

    private String password;

    @Override
    public String toString() {
        return "Employee{name=" + name + ",id=" + id + ",salary=" + salary + ",age=" + age + ",password=" + password + "}";
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


    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Employee.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
