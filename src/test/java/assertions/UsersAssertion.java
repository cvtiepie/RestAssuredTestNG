package assertions;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class UsersAssertion extends BaseAssertion {


    public ValidatableResponse response;

    public UsersAssertion(ValidatableResponse response) {
        super(response);
        this.response = response;
    }
    
    public void checkPageNumber(int pageNumber) {
        this.response.body("page", equalTo(pageNumber));
    }

    public void checkAmountOfItems() {
        this.response.body("data.findall.size()", equalTo(6));
    }

    public void checkUserId(int userId) {
        this.response.body("data.id", equalTo(userId));
    }
}
