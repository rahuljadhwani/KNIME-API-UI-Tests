package services;

import constants.APIPaths;
import io.restassured.response.Response;
import utils.api.TokenManager;

import static io.restassured.RestAssured.given;

/**
 * This class contains reusable methods for APIs to delete public and private spaces
 *
 */
public class DeleteSpace {

    public Response deleteSpace(){
        return given(BaseService.getRequestSpec(APIPaths.getDeleteSpacePath()).auth().oauth2(TokenManager.getToken())).when().delete()
                .then().spec(BaseService.getResponseSpec()).extract().response();
    }


}
