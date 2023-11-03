package ru.respublica.models.catalog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogResponseModel {
    private boolean success;
    private String title;
    private PaginationModel pagination;
}
