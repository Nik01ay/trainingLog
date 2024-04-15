package org.example;

import org.example.inMemoryRepo.UserInMemoryRepo;

public class Security {
    private final UserInMemoryRepo userRepo;

    public Security(UserInMemoryRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean authentification(String user, String password) {

        if (userRepo.getUserByName(user)
                .getPassword()
                .equals(password)) {
            CacheData.setCurrentSessionUserName(user);
            return true;
        }
        return false;
    }
}
