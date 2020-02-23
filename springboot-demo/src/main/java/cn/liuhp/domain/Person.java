package cn.liuhp.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private String name;

    private Integer age;

    private Date birthday;

    public static void main(String[] args) {
        System.out.println(new Person().getAge());
    }
}
