package assertions;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class ResourcesAssertion extends BaseAssertion {

    public ValidatableResponse response;

    public ResourcesAssertion(ValidatableResponse response) {
        super(response);
        this.response = response;
    }

    public void checkListOfResourcesPage() {
        this.response.body("page", equalTo(1));
    }

    public void checkListOfResourcesItems() {
        this.response.body("data.findall.size()", equalTo(6));
    }

    public void checkResourceItem(int expectedId) {
        this.response.body("data.id", equalTo(expectedId));
    }


}
