package ru.respublica.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.respublica.models.authorization.AuthorizationRequestModel;
import ru.respublica.models.authorization.UserInfoResponseModel;
import ru.respublica.models.authorization.UserRequestModel;
import ru.respublica.models.basket.AddingToBasketRequestModel;
import ru.respublica.models.basket.AddingToBasketResponseModel;
import ru.respublica.models.basket.DeletionResponseModel;
import ru.respublica.models.basket.ItemRequestModel;
import ru.respublica.utils.Variables;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.respublica.specs.BasicSpec.requestSpec;
import static ru.respublica.specs.BasicSpec.responseSpec200;
import static ru.respublica.tests.TestBase.authConfig;

@Feature("Корзина")
public class BasketTests {

    Variables variables = new Variables();

    @Test
    @Tag("basket")
    @Owner("jmalkova")
    @DisplayName("Добавление товара в корзину")
    void articleAddingTest() {

        AuthorizationRequestModel authInfo = new AuthorizationRequestModel();
        UserRequestModel userRequestModel = new UserRequestModel();
        authInfo.setUser(userRequestModel);
        authInfo.getUser().setEmail(authConfig.login());
        authInfo.getUser().setPassword(authConfig.password());

        UserInfoResponseModel loginResponse = step("Отправить POST запрос для авторизации пользователя", () -> given(requestSpec).body(authInfo).when().post("/users/login").then().spec(responseSpec200).extract().as(UserInfoResponseModel.class));

        DeletionResponseModel deletionResponse = step("Отправить POST запрос для удаления книг из корзины", () -> given(requestSpec).header("Jwt-Auth-Token", loginResponse.getToken()).when().post("/cart/clear").then().spec(responseSpec200).extract().as(DeletionResponseModel.class));

        AddingToBasketRequestModel addRequest = new AddingToBasketRequestModel();
        ItemRequestModel itemRequestModel = new ItemRequestModel();
        addRequest.setItem(itemRequestModel);
        itemRequestModel.setItemId(variables.randomArticle);
        itemRequestModel.setQuantity(variables.randomQuantity);
        itemRequestModel.setUpdate(true);

        AddingToBasketResponseModel addResponse = step("Отправить POST запрос для добавления случайного товара в корзину", () -> given(requestSpec).body(addRequest).when().post("/cart/add_item").then().spec(responseSpec200).extract().as(AddingToBasketResponseModel.class));
        step("Проверить ответ", () -> {
            assertEquals(true, addResponse.isSuccess());
            assertEquals("Товар добавлен", addResponse.getMessage());
            assertEquals(variables.randomArticle, addResponse.getCart().getItems().get(0).getItem().getData().getId());
            assertEquals(variables.articlePrice, addResponse.getCart().getItems().get(0).getPrice());
            assertEquals(variables.randomQuantity, addResponse.getCart().getItems().get(0).getQuantity());
        });
    }

    @Test
    @Tag("basket")
    @Owner("jmalkova")
    @DisplayName("Удаление всех товаров из корзины")
    void articlesDeletionTest() {

        AuthorizationRequestModel authInfo = new AuthorizationRequestModel();
        UserRequestModel userRequestModel = new UserRequestModel();
        authInfo.setUser(userRequestModel);
        authInfo.getUser().setEmail(authConfig.login());
        authInfo.getUser().setPassword(authConfig.password());

        UserInfoResponseModel loginResponse = step("Отправить POST запрос для авторизации пользователя", () -> given(requestSpec).body(authInfo).when().post("/users/login").then().spec(responseSpec200).extract().as(UserInfoResponseModel.class));

        DeletionResponseModel deletionResponse = step("Отправить POST запрос для удаления книг из корзины", () -> given(requestSpec).header("Jwt-Auth-Token", loginResponse.getToken()).when().post("/cart/clear").then().spec(responseSpec200).extract().as(DeletionResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(true, deletionResponse.isSuccess());
            assertEquals("Корзина очищена", deletionResponse.getMessage());
        });
    }
}