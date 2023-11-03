package ru.respublica.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.respublica.models.catalog.CatalogResponseModel;
import ru.respublica.utils.Variables;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.respublica.specs.BasicSpec.requestSpec;
import static ru.respublica.specs.BasicSpec.responseSpec200;

@Feature("Каталог")
public class CatalogTests {

    Variables variables = new Variables();

    @Test
    @Tag("catalog")
    @Owner("jmalkova")
    @DisplayName("Поиск товаров в каталоге")
    void catalogSearchTest() {

        CatalogResponseModel catalogResponseModel = step("Отправить GET запрос для поиска товаров", () ->
                given(requestSpec)
                        .param("query", variables.randomSearchInput)
                        .when()
                        .get("/listing/search")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(CatalogResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(true, catalogResponseModel.isSuccess());
            assertEquals("Результаты поиска: " + variables.randomSearchInput, catalogResponseModel.getTitle());
            assertTrue(catalogResponseModel.getPagination().getCount()>0);
        });
    }
    @ParameterizedTest(name = "Получение товаров из раздела {0} каталога")
    @Tag("catalog")
    @Owner("jmalkova")
    @CsvFileSource(resources = "/sections.csv")
    void catalogTest(String sectionName, String sectionPath) {

        CatalogResponseModel catalogResponseModel = step("Отправить GET запрос для поиска товаров", () ->
                given(requestSpec)
                        .when()
                        .get("/listing/"+ sectionPath)
                        .then()
                        .spec(responseSpec200)
                        .extract().as(CatalogResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(true, catalogResponseModel.isSuccess());
            assertEquals(sectionName, catalogResponseModel.getTitle());
            assertTrue(catalogResponseModel.getPagination().getCount()>0);
        });
    }
}