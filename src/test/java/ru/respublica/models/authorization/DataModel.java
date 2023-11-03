package ru.respublica.models.authorization;

import lombok.Data;

@Data
public class DataModel {
    private String id, type;
    private AttributeModel attributes;
}