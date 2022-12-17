package site.stellarburgers.nomoreparties.rest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.request;

public class UserApi {

    Filter requestFilter = new RequestLoggingFilter();
    Filter responseFiler = new ResponseLoggingFilter();
    Filter allureLogger = new AllureRestAssured();

    public void deleteUser(UserPojo user){
        String accessToken = RestAssured
                .given()
                .filters(requestFilter, responseFiler, allureLogger)
                .contentType(ContentType.JSON)
                .body(user)
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then()
                .extract().body().path("accessToken").toString();

        RestAssured
                .given()
                .filters(requestFilter, responseFiler, allureLogger)
                .contentType(ContentType.JSON)
                .headers("Authorization", accessToken)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
    }
}
