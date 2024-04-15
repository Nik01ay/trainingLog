package org.example.manager;

import org.example.CacheData;
import org.example.Security;
import org.example.entity.UserEntity;
import org.example.entity.UserRole;
import org.example.inMemoryRepo.UserInMemoryRepo;

public class UserManager {
    private UserInMemoryRepo userRepo;
    private Security security;

    public UserManager(UserInMemoryRepo userRepo) {
        this.userRepo = userRepo;
        this.security = new Security(userRepo);
    }

    public void addNewUser(String userName, String password, String userStringRole) {
        UserEntity newUser = new UserEntity();
        newUser.setName(userName);
        newUser.setPassword(password);
        if(userStringRole.equals(UserRole.ADMIN.toString())) {
            newUser.setRole(UserRole.ADMIN);
        } else newUser.setRole(UserRole.USER);
        userRepo.addUser(newUser);
        System.out.println("Пользователь добавлен!");
    }

    public void identificationUser(String userName, String password) {
        security.authentification(userName, password);
    }

   public void logout(){
        CacheData.resetSession();
   }
}
