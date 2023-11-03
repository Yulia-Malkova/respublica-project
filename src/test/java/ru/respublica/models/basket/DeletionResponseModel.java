package ru.respublica.models.basket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletionResponseModel {
    private boolean success;
    private String message;

}
