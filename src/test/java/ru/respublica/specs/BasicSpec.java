package ru.respublica.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.respublica.helpers.CustomApiListener;
import ru.respublica.tests.TestBase;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class BasicSpec extends TestBase {

    public static RequestSpecification requestSpec = with().filter(CustomApiListener.withCustomTemplates()).log().uri().log().method().log().body().contentType(ContentType.JSON).baseUri(apiConfig.baseUrl()).basePath(apiConfig.basePath());

    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder().log(STATUS).log(BODY).expectStatusCode(200).build();

    public static ResponseSpecification responseSpec401 = new ResponseSpecBuilder().log(STATUS).log(BODY).expectStatusCode(401).build();

}
