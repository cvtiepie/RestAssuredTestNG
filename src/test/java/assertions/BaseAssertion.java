package assertions;

import io.restassured.response.ValidatableResponse;

public class BaseAssertion {

    public ValidatableResponse response;

    public BaseAssertion(ValidatableResponse response) {
        this.response = response;
    }
    public void checkStatusCode(int expectedCode) {
        this.response.statusCode(expectedCode);
    }
}
