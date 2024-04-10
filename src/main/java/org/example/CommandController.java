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

    public void login(String name, String password) {
      String userName =  userManager.identificationUser(name, password);
        System.out.println("активный пользователь = " + userName);
    }
    public void logout() {
        userManager.logout();
    }
}
