package org.example.manager;

import org.example.CacheData;
import org.example.Security;
import org.example.entity.UserEntity;
import org.example.entity.UserRole;
import org.example.inMemoryRepo.UserInMemoryRepo;

public class UserManager {
    private final UserInMemoryRepo userRepo;
    private final Security security;

    public UserManager(UserInMemoryRepo userRepo, Security security) {
        this.userRepo = userRepo;
        this.security = security;
    }

    public void addNewUser(String userName, String password, String userStringRole) {
        UserEntity newUser = new UserEntity();
        newUser.setName(userName);
        newUser.setPassword(password);
        if(userStringRole.equals(UserRole.ADMIN.toString())) {
            newUser.setRole(UserRole.ADMIN);
        } else newUser.setRole(UserRole.USER);
        userRepo.addUser(newUser);
        CacheData.setCountUser(userRepo.size());
        security.refreshAcsessMethod();
        System.out.println("User added!");

    }

    public void identificationUser(String userName, String password) {
        security.authentification(userName, password);
    }

   public void logout(){

        security.logout();
   }
}
