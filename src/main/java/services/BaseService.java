package services;

import constants.APIPaths;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseService {

    public static RequestSpecification getRequestSpec(String basePath) {
        return new RequestSpecBuilder().
                setBaseUri(APIPaths.getBaseURI()).
                setBasePath(basePath).
                setContentType(ContentType.JSON).
                build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }

}
