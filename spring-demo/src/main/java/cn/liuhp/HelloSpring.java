package cn.liuhp;

/**
 * @description: demo
 * @author: liuhp534
 * @create: 2019-06-09 11:58
 */
public class HelloSpring {

    public HelloSpring() {
        System.out.println("constructor helloSpring");
    }

    public void sayHello() {
        System.out.println("hello : " + this.name);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName " + name);
        this.name = name;
    }
}
