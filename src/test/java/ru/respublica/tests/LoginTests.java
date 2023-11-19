package ru.respublica.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.respublica.models.authorization.AuthorizationRequestModel;
import ru.respublica.models.authorization.UserInfoResponseModel;
import ru.respublica.models.authorization.UserRequestModel;
import ru.respublica.utils.Endpoints;
import ru.respublica.utils.Variables;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.respublica.specs.BasicSpec.*;
import static ru.respublica.tests.TestBase.authConfig;

public class LoginTests {
    Variables variables = new Variables();

    @Test
    @Tag("login")
    @Feature("Авторизация")
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
                        .post(Endpoints.LOGIN.getName())
                        .then()
                        .spec(responseSpec200)
                        .extract().as(UserInfoResponseModel.class));

        step("Проверить ответ", () ->
                assertAll(
                        "Проверка значений для isSuccess, email в полученном ответе",
                        () -> assertEquals(true, response.isSuccess()),
                        () -> assertEquals(authConfig.login(), response.getUser().getData().getAttributes().getEmail())
                )
        );
    }

    @Test
    @Tag("login")
    @Feature("Авторизация")
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
                        .post(Endpoints.LOGIN.getName())
                        .then()
                        .spec(responseSpec401)
                        .extract().as(UserInfoResponseModel.class));

        step("Проверить ответ", () ->
                assertAll(
                        "Проверка значений для isSuccess, message в полученном ответе",
                        () -> assertEquals(false, response.isSuccess()),
                        () -> assertEquals("Невалидные данные для авторизации", response.getMessage())
                )
        );
    }
}