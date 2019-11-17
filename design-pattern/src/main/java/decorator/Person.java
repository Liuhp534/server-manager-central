package decorator;

/*
* 被装饰的主体
* */
public abstract class Person {

    private String name;

    public abstract String run();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
