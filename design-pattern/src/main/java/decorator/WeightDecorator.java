package decorator;

/*
* 装饰某某人
* */
public class WeightDecorator extends DecoratorPerson {

    public WeightDecorator(Person delegate) {
        this.delegate = delegate;
    }

    @Override
    public String run() {
        return "绑着沙袋，" + this.delegate.run();
    }
}
