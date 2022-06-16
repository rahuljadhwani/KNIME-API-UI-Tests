package services;

import constants.APIPaths;
import io.restassured.response.Response;
import pages.apipojos.CreateSpacePojo;
import utils.api.TokenManager;

import static io.restassured.RestAssured.given;

/**
 * This class contains reusable methods for APIs to create public and private spaces
 *
 */
public class CreateSpace {

    public Response createPublicSpace(boolean overwriteSpaceDetails) {
        return given(BaseService.getRequestSpec(APIPaths.getCreateSpacePath()).auth().oauth2(TokenManager.getToken())
                .body(createSpaceBody(false))).queryParam("overwrite", overwriteSpaceDetails).when().put().then().spec(BaseService.getResponseSpec()).extract().response();
    }

    public Response createPrivateSpace(boolean overwriteSpaceDetails) {
        return given(BaseService.getRequestSpec(APIPaths.getCreateSpacePath()).auth().oauth2(TokenManager.getToken())
                .body(createSpaceBody(true))).queryParam("overwrite", overwriteSpaceDetails).when().put().then().spec(BaseService.getResponseSpec()).extract().response();
    }


    private CreateSpacePojo createSpaceBody(boolean isPrivate){
        CreateSpacePojo createSpacePojo = new CreateSpacePojo();
        createSpacePojo.setPrivateSpace(isPrivate);
        createSpacePojo.setType("Space");
        return createSpacePojo;
    }

}
