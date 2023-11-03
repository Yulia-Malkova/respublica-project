package ru.respublica.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.respublica.models.authorization.AuthorizationRequestModel;
import ru.respublica.models.authorization.UserInfoResponseModel;
import ru.respublica.models.authorization.UserRequestModel;
import ru.respublica.utils.Variables;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.respublica.specs.BasicSpec.*;
import static ru.respublica.tests.TestBase.authConfig;

@Feature("Авторизация")
public class LoginTests {
    Variables variables = new Variables();

    @Test
    @Tag("login")
    @Owner("jmalkova")
    @DisplayName("Авторизация существующего пользователя с верным паролем")
    void successfulAuthorizationTest() {

        AuthorizationRequestModel authInfo = new AuthorizationRequestModel();
        UserRequestModel userRequestModel = new UserRequestModel();
        authInfo.setUser(userRequestModel);
        authInfo.getUser().setEmail(authConfig.login());
        authInfo.getUser().setPassword(authConfig.password());

        UserInfoResponseModel response = step("Отправить POST запрос для авторизации пользователя", () ->
                given(requestSpec)
                        .body(authInfo)
                        .when()
                        .post("/users/login")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(UserInfoResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(true, response.isSuccess());
            assertEquals(authConfig.login(), response.getUser().getData().getAttributes().getEmail());
        });
    }

    @Test
    @Tag("login")
    @Owner("jmalkova")
    @DisplayName("Ошибка при авторизации с некорректными данными")
    void authorizationErrorTest() {

        AuthorizationRequestModel authInfo = new AuthorizationRequestModel();
        UserRequestModel userRequestModel = new UserRequestModel();
        authInfo.setUser(userRequestModel);
        authInfo.getUser().setEmail(authConfig.login());
        authInfo.getUser().setPassword(variables.randomPassword);

        UserInfoResponseModel response = step("Отправить POST запрос для авторизации пользователя", () ->
                given(requestSpec)
                        .body(authInfo)
                        .when()
                        .post("/users/login")
                        .then()
                        .spec(responseSpec401)
                        .extract().as(UserInfoResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(false, response.isSuccess());
            assertEquals("Невалидные данные для авторизации", response.getMessage());
        });
    }
}