package observer;

import java.util.Observable;

/*
*
* 这种是维护一个observer集合，通过遍历的方式发布消息
* */
public class WeatherData extends Observable {

    private String color;

    private String template;

    /*
    * 发布改变
    * */
    public void push() {
        color = "red";
        template = "23";
        this.setChanged();
        this.notifyObservers(this);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
