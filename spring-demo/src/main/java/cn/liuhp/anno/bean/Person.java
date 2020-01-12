package cn.liuhp.anno.bean;

import lombok.Data;

@Data
public class Person {

    public Person (Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;

    private String name;
}
