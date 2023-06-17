package geekbrains.lesson6;

import geekbrains.lesson6.srp2.Order;
import geekbrains.lesson6.srp2.Saver;

public class Program {

    public static void main(String[] args) {
        Order order = new Order("Bruce Wayne", "Porche", 5,500000);
        Saver saver = new Saver();
        saver.saveToJson(order);
        saver.saveToXML(order);
        Order order1 = new Order();
        System.out.println(order1);
    }

}
