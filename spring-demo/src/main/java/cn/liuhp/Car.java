package cn.liuhp;

/**
 * @description: 汽车实例
 * @author: liuhp534
 * @create: 2019-06-09 14:41
 */
public class Car {

    private String carName;

    private double price;

    private int maxSpeed;

    public Car(String carName, int maxSpeed) {
        this.carName = carName;
        this.maxSpeed = maxSpeed;
    }

    public Car(String carName, double price) {
        this.carName = carName;
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
