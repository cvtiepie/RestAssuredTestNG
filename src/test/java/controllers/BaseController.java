package controllers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseController {

    public static Response getRequest(String url) {
        return given().get(url);
    }

    public static Response postRequest(String url, String body) {
        return given().body(body).when().post(url);
    }

    public static Response patchRequest(String url, String body) {
        return given().body(body).when().patch(url);
    }

    public static Response putRequest(String url, String body) {
        return given().body(body).when().put(url);
    }

    public static Response deleteRequest(String url) {
        return given().delete(url);
    }
}
