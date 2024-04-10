package org.example;

public class CommandController {

    public void method1() {
        System.out.println("Вызван метод 1");
    }

    public void method2(String a, String b) {
        System.out.println("Вызван метод 2");
        System.out.println("a " + a);
        System.out.println("b " + b);
    }
}
