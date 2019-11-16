package observer;

public class ObserverMain {


    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(new OneObserver());
        weatherData.addObserver(new TwoObserver());

        /*
        * 发布消息是倒叙的，不清楚为啥
        * */
        weatherData.push();
    }

}
