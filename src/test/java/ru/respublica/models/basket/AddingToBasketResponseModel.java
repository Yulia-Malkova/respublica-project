package ru.respublica.models.basket;

import lombok.Data;

@Data
public class AddingToBasketResponseModel {
    private boolean success;
    private String message;
    private CartModel cart;

}
