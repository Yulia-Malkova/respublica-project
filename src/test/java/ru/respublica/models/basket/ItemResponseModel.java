package ru.respublica.models.basket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponseModel {
    private int quantity, price;
    private ItemModel item;

}
