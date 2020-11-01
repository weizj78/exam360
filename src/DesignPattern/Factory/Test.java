package DesignPattern.Factory;

public class Test {
    public static void main(String[] args) {
        Factory f = new BenzFactory();
        f.getCar().run();
    }
}
interface Car{
    void run();
}
class Benz implements Car {

    @Override
    public void run() {
        System.out.println("生产一辆奔驰");
    }
}

class BMW implements Car {

    @Override
    public void run() {
        System.out.println("生产一辆宝马");
    }
}
interface Factory{
    Car getCar();
}
class BMWFactory implements Factory{

    @Override
    public Car getCar() {
        return new BMW();
    }
}

class BenzFactory implements Factory{

    @Override
    public Car getCar() {
        return new Benz();
    }
}