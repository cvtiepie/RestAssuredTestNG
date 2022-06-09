package services;

import controllers.BaseController;
import data.Endpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;

public class ReqResApiService {

    public static ValidatableResponse getPageWithUsers(int pageNumber) {
        Response response = BaseController.getRequest(Endpoints.BaseUrl + Endpoints.UserListService + pageNumber);
        return response.then();
    }

    public static ValidatableResponse getSingUser(int userId) {
        Response response = BaseController.getRequest(Endpoints.BaseUrl + Endpoints.SingleUserService + userId);
        return response.then();
    }

    public static ValidatableResponse getResourceList() {
        Response response = BaseController.getRequest(Endpoints.BaseUrl + Endpoints.UnknownService);
        return response.then();
    }

    public static ValidatableResponse getResourceItem(int itemId) {
        Response response = BaseController.getRequest(Endpoints.BaseUrl + Endpoints.UnknownService + itemId);
        return response.then();
    }

    public static ValidatableResponse createUser(String name, String job) {
        JSONObject request = new JSONObject();
        request.put("name", name);
        request.put("job", job);
        Response response = BaseController.postRequest(Endpoints.BaseUrl + Endpoints.SingleUserService, request.toJSONString());
        return response.then();
    }

    public static ValidatableResponse patchUser(int userId, String name, String job) {
        JSONObject request = new JSONObject();
        request.put("name", name);
        request.put("job", job);
        Response response = BaseController.patchRequest(Endpoints.BaseUrl + Endpoints.SingleUserService + userId, request.toJSONString());
        return response.then();
    }

    public static ValidatableResponse updateUser(int userId, String name, String job) {
        JSONObject request = new JSONObject();
        request.put("name", name);
        request.put("job", job);
        Response response = BaseController.putRequest(Endpoints.BaseUrl + Endpoints.SingleUserService + userId, request.toJSONString());
        return response.then();
    }

    public static ValidatableResponse deleteUser(int userId) {
        Response response = BaseController.deleteRequest(Endpoints.BaseUrl + Endpoints.SingleUserService + userId);
        return response.then();
    }

}
