package org.example.entity;

import lombok.Data;

import javax.swing.*;
@Data
public class UserEntity {
    String name;
    String password; //JPasswordField password;
    UserRole role;
}
