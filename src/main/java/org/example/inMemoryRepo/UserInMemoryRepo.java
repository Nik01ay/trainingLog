package org.example.inMemoryRepo;

import org.example.entity.UserEntity;

import java.util.HashMap;
import java.util.Optional;

public class UserInMemoryRepo {
    private HashMap<String, UserEntity> userEntityHashMap = new HashMap<>();

    public void addUser(UserEntity user){
        userEntityHashMap.put(user.getName(), user);
    }

    public UserEntity getUserByName(String name){
        return Optional.ofNullable(userEntityHashMap.get(name))
                .orElseThrow(IllegalArgumentException::new);
    }
    public boolean authentication(UserEntity user, String password)
    {
        return userEntityHashMap.get(user.getName())
                .getPassword()
                .equals(password);
    }


}
