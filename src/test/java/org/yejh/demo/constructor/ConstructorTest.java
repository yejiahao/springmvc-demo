package org.yejh.demo.constructor;

import java.lang.reflect.Constructor;

public class ConstructorTest {
    public static void main(String[] args) {
        Class<Bean> c = Bean.class;

        try {
            Constructor<Bean> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(Boolean.TRUE);
            Bean b1 = constructor.newInstance();
            System.out.println("b1: " + b1);

            System.out.println("-------------------------------------------------------------");

            Constructor<Bean> constructor2 = c.getDeclaredConstructor(new Class[]{double.class, String.class});
            constructor2.setAccessible(Boolean.TRUE);

            Bean b2 = constructor2.newInstance(new Object[]{3800, "Samsung Galaxy Note3"});
            System.out.println("b2: " + b2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Bean {
    private double price;
    private String brand;

    {
        System.out.println("default constructor block");
    }

    private Bean() {
        System.out.println("no signature constructor method");
    }

    private Bean(double price, String brand) {
        System.out.println("signature constructor method");
        this.price = price;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bean [price=" + price + ", brand=" + brand + "]";
    }

}
