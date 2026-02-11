package com.automationexercise.api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class AutomationExerciseApi {

    public static io.restassured.response.Response getProductsList() {
        return given()
                .when()
                .get(ApiRoutes.PRODUCTS_LIST);
    }

    public static io.restassured.response.Response postProductsListExpect405() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .post(ApiRoutes.PRODUCTS_LIST);
    }

    public static io.restassured.response.Response getBrandsList() {
        return given()
                .when()
                .get(ApiRoutes.BRANDS_LIST);
    }

    public static io.restassured.response.Response putBrandsListExpect405() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .put(ApiRoutes.BRANDS_LIST);
    }

    public static io.restassured.response.Response postSearchProduct(String searchText) {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("search_product", searchText)
                .when()
                .post(ApiRoutes.SEARCH);
    }

    public static io.restassured.response.Response postSearchProductMissingParam() {
        return given()
                .contentType(ContentType.URLENC)
                .when()
                .post(ApiRoutes.SEARCH);
    }

    public static io.restassured.response.Response postVerifyLogin(String email, String password) {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post(ApiRoutes.VERIFY_LOGIN);
    }

    public static io.restassured.response.Response postVerifyLoginMissingEmail(String password) {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("password", password)
                .when()
                .post(ApiRoutes.VERIFY_LOGIN);
    }

    public static io.restassured.response.Response deleteVerifyLoginExpect405() {
        return given()
                .when()
                .delete(ApiRoutes.VERIFY_LOGIN);
    }
}
