package tests;

import assertions.ResourcesAssertion;
import assertions.UsersAssertion;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import services.ReqResApiService;

public class ExampleTest {
    @Test
    public void getLisOfUsers() {
        ValidatableResponse response = ReqResApiService.getPageWithUsers(2);
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkAmountOfItems();
        assertion.checkStatusCode(200);
        assertion.checkPageNumber(2);
    }

    @Test
    public void getSingleUser() {
        ValidatableResponse response = ReqResApiService.getSingUser(2);
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkStatusCode(200);
        assertion.checkUserId(2);
    }

    @Test
    public void getUserNotFound() {
        ValidatableResponse response = ReqResApiService.getSingUser(23);
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkStatusCode(404);
    }

    @Test
    public void getResourcesList() {
        ValidatableResponse response = ReqResApiService.getResourceList();
        ResourcesAssertion assertion = new ResourcesAssertion(response);
        assertion.checkStatusCode(200);
        assertion.checkListOfResourcesItems();
        assertion.checkListOfResourcesPage();
    }

    @Test
    public void getResourcesItem() {
        ValidatableResponse response = ReqResApiService.getResourceItem(2);
        ResourcesAssertion assertion = new ResourcesAssertion(response);
        assertion.checkStatusCode(200);
        assertion.checkResourceItem(2);
    }

    @Test
    public void getResourcesItemNotFound() {
        ValidatableResponse response = ReqResApiService.getResourceItem(23);
        ResourcesAssertion assertion = new ResourcesAssertion(response);
        assertion.checkStatusCode(404);
    }

    @Test
    public void createUser() {
        ValidatableResponse response = ReqResApiService.createUser("Vasya", "AQA");
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkStatusCode(201);
    }

    @Test
    public void patchUser() {
        ValidatableResponse response = ReqResApiService.patchUser(2, "Dima", "DEV");
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkStatusCode(200);
    }

    @Test
    public void updateUser() {
        ValidatableResponse response = ReqResApiService.updateUser(2, "Kolya", "BA");
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkStatusCode(200);
    }

    @Test
    public void deleteUser() {
        ValidatableResponse response = ReqResApiService.deleteUser(2);
        UsersAssertion assertion = new UsersAssertion(response);
        assertion.checkStatusCode(204);
    }

}
