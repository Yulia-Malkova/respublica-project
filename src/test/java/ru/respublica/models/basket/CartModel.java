package ru.respublica.models.basket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartModel {
    private List<ItemResponseModel> items;
}
