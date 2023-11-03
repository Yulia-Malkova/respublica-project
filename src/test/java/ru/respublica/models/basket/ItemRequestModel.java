package ru.respublica.models.basket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRequestModel {
    private int quantity;
    private boolean update;
    @JsonProperty("item_id")
    private String itemId;

}
