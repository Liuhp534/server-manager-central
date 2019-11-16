package observer;

import java.util.Observable;
import java.util.Observer;

/*
*
* 根据WeatherData发布的消息，被动的接收
* */
public class OneObserver implements Observer {


    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof WeatherData) {
            System.out.println(this.getClass() + "=" + ((WeatherData) arg).getColor());
            System.out.println(this.getClass() + "=" + ((WeatherData) arg).getTemplate());
        }
    }
}
