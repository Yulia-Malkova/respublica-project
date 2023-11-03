package ru.respublica.models.authorization;

import lombok.Data;

@Data
public class UserInfoResponseModel {
    private String token;
    private boolean success;
    private UserModel user;
    private String message;
}

