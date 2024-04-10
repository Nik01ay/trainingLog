package org.example;

public class CommandController {

    private UserManager userManager;

    public CommandController(UserManager userManager) {
        this.userManager = userManager;
    }

    public void addNewUser(String name, String password, String role) {
        userManager.addNewUser(name, password, role);
        System.out.println("Пользователь добавлен!");

    }

    public void method2(String a, String b) {
        System.out.println("Вызван метод 2");
        System.out.println("a " + a);
        System.out.println("b " + b);
    }
}
