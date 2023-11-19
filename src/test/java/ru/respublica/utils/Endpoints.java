package ru.respublica.utils;

public enum Endpoints {
    LOGIN("/users/login"),
    ACCOUNT_UPDATE("/account/update"),
    CART_CLEAR("/cart/clear"),
    CART_ADD("/cart/add_item"),
    LISTING_SIMPLE("/listing/"),
    LISTING_SEARCH("/listing/search");

    private final String name;

    Endpoints(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
