package services;

import constants.APIPaths;
import io.restassured.response.Response;
import pages.apipojos.CreateSpacePojo;
import utils.api.TokenManager;

import static io.restassured.RestAssured.given;

public class CreateSpace {

    public Response createPublicSpace(boolean overwriteSpaceDetails) {
        return given(BaseService.getRequestSpec(APIPaths.getCreateSpacePath()).auth().oauth2(TokenManager.getToken())
                .body(createPublicSpaceBody())).queryParam("overwrite", overwriteSpaceDetails).when().put().then().spec(BaseService.getResponseSpec()).extract().response();
    }

    public Response createPrivateSpace(boolean overwriteSpaceDetails) {
        return given(BaseService.getRequestSpec(APIPaths.getCreateSpacePath()).auth().oauth2(TokenManager.getToken())
                .body(createPrivateSpaceBody())).queryParam("overwrite", overwriteSpaceDetails).when().put().then().spec(BaseService.getResponseSpec()).extract().response();
    }


    private CreateSpacePojo createPublicSpaceBody(){
        CreateSpacePojo createSpacePojo = new CreateSpacePojo();
        createSpacePojo.setPrivateSpace(false);
        createSpacePojo.setType("Space");
        return createSpacePojo;
    }

    private CreateSpacePojo createPrivateSpaceBody(){
        CreateSpacePojo createSpacePojo = new CreateSpacePojo();
        createSpacePojo.setPrivateSpace(true);
        createSpacePojo.setType("Space");
        return createSpacePojo;
    }
}
