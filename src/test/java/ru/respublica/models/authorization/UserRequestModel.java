package ru.respublica.models.authorization;

import lombok.Data;

@Data
public class UserRequestModel {
    private String email, password;

}