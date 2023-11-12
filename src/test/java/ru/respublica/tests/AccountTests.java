package ru.respublica.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.respublica.models.authorization.AuthorizationRequestModel;
import ru.respublica.models.authorization.UserInfoResponseModel;
import ru.respublica.models.authorization.UserRequestModel;
import ru.respublica.models.account.InfoUpdateRequestModel;
import ru.respublica.models.account.UserInfoModel;
import ru.respublica.utils.Variables;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.respublica.specs.BasicSpec.requestSpec;
import static ru.respublica.specs.BasicSpec.responseSpec200;
import static ru.respublica.tests.TestBase.authConfig;

@Feature("Личный кабинет")
public class AccountTests {

    Variables variables = new Variables();

    @Test
    @Tag("account")
    @Owner("jmalkova")

    @DisplayName("Изменение данных пользователя в личном кабинете")
    void userInformationUpdateTest() {

        AuthorizationRequestModel authInfo = new AuthorizationRequestModel();
        UserRequestModel userRequestModel = new UserRequestModel();
        authInfo.setUser(userRequestModel);
        authInfo.getUser().setEmail(authConfig.login());
        authInfo.getUser().setPassword(authConfig.password());

        UserInfoResponseModel loginResponse = step("Отправить POST запрос для авторизации пользователя", () ->
                given(requestSpec)
                        .body(authInfo)
                        .when()
                        .post("/users/login")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(UserInfoResponseModel.class));

        InfoUpdateRequestModel infoUpdate = new InfoUpdateRequestModel();
        UserInfoModel userInfoModel = new UserInfoModel();
        infoUpdate.setUser(userInfoModel);
        userInfoModel.setFirstName(variables.randomFirstName);
        userInfoModel.setLastName(variables.randomLastName);

        UserInfoResponseModel userInfoResponse = step("Отправить POST запрос для изменения данных пользователя", () ->
                given(requestSpec)
                        .header("Jwt-Auth-Token", loginResponse.getToken())
                        .body(infoUpdate)
                        .when()
                        .post("/account/update")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(UserInfoResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(true, userInfoResponse.isSuccess());
            assertEquals(variables.randomFirstName, userInfoResponse.getUser().getData().getAttributes().getFirstName());
            assertEquals(variables.randomLastName, userInfoResponse.getUser().getData().getAttributes().getLastName());
        });
    }
}
