package DesignPattern.FactoryPattern;

public class SampleFactory {
    public static void main(String[] args) {
        SampleFactory.getCar("宝马").run();
    }

    public static Car getCar(String type){
        switch(type){
            case "宝马": return new BMW();
            case "奔驰": return new Benz();
            default: return null;
        }
    }
}
interface Car{
    void run();
}
class Benz implements Car{

    @Override
    public void run() {
        System.out.println("生产一辆奔驰");
    }
}

class BMW implements Car{

    @Override
    public void run() {
        System.out.println("生产一辆宝马");
    }
}

