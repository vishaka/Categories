package TestScenarios;

import Utilities.Constants;
import Utilities.GenerateRequestBody;
import Utilities.HeadersAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import java.util.Map;

public class Stepdefs {

    HeadersAPI headers;
    String apiUrl;
    ValidatableResponse response;
    Map<String,String> headersMap;
    GenerateRequestBody requestBody;
    String postbodycontent;
    @Given("Generate the api end point with limit {int} and skip value {int}")
    public void generateTheApiEndPointWithLimitAndSkipValue(int limit, int skip) {
        apiUrl= Constants.baseurl+"?$limit="+limit+"&$skip="+skip;
    }

    @Then("Create api header")
    public void createApiHeader() {
        headers= new HeadersAPI();
        headersMap=headers.getHeaders();
    }

    @And("Send the request and validate {int} response code")
    public void sendTheRequestAndValidateResponseCode(int responseCode) {
         response= RestAssured.given()
                                        .log().all()
                                        .contentType(ContentType.JSON)
                                        .headers(headersMap)
                                        .get(apiUrl)
                                        .then().log().all()
                                        .assertThat().statusCode(responseCode);
         System.out.println("Response :"+response.extract().body().asString());
    }


    @Given("Generate the api end point with out limit and skip value")
    public void generateTheApiEndPointWithOutLimitAndSkipValue() {
        apiUrl= Constants.baseurl;
    }

    @Given("Generate the api end point with limit {string} and skip value {string}")
    public void generateTheApiEndPointWithLimitAndSkipValue(String limit, String skip) {
        apiUrl= Constants.baseurl+"?$limit="+limit+"&$skip="+skip;
    }


    @Then("Validate the error {string}")
    public void validateTheError(String message) {

        String actualError= response.extract().jsonPath().getString("message");
        Assert.assertEquals(actualError,message);

    }

    @Given("Generate the api end point")
    public void generateTheApiEndPoint() {
        apiUrl= Constants.baseurl;
    }


    @And("Generate the request body {string} and {string}")
    public void generateTheRequestBodyAnd(String name, String id) {
        requestBody=new GenerateRequestBody();
        postbodycontent=requestBody.generateReqBody(id,name);
    }

    @And("Send the request with request body and validate {int} response code")
    public void sendTheRequestWithRequestBodyAndValidateResponseCode(int responseCode) {
        response= RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .headers(headersMap)
                .body(postbodycontent)
                .post(apiUrl)
                .then().log().all()
                .assertThat().statusCode(responseCode);
        System.out.println("Response :"+response.extract().body().asString());
    }

    @And("Generate the request body with values {int} and {int}")
    public void generateTheRequestBodyWithValuesAnd(Object id, Object name) {

        postbodycontent="{name="+name+",id="+id+"}";
    }



    @And("Send the request with request body and validate {int}")
    public void sendTheRequestWithRequestBodyAndValidate(int code) {
        response= RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .headers(headersMap)
                .body(postbodycontent)
                .post(apiUrl)
                .then().log().all()
                .assertThat().statusCode(code);
        System.out.println("Response :"+response.extract().body().asString());
    }


    @And("Generate the request body with values {string} and {int}")
    public void generateTheRequestBodyWithValuesAnd(String name, int id) {
        postbodycontent="{name="+name+",id="+id+"}";
    }


    @Given("Generate the api end point with specific {int}")
    public void generateTheApiEndPointWithSpecific(int id) {
        apiUrl= Constants.baseurl+"/"+id;
    }

    @Then("Validate the reponse message contains {string}")
    public void validateTheReponseMessageContains(String id) {
        String actualId= response.extract().jsonPath().getString("id");
        Assert.assertEquals(actualId,id);
    }

    @Given("Generate the api end point with specific {string}")
    public void generateTheApiEndPointWithSpecific(String id) {
        apiUrl= Constants.baseurl+"/"+id;
    }

    @Given("Generate the api end point to update id {int}")
    public void generateTheApiEndPointToUpdateId(int id) {
        apiUrl= Constants.baseurl+"/"+id;
    }

    @And("Send the patch request with request body and validate {int} response code")
    public void sendThePatchRequestWithRequestBodyAndValidateResponseCode(int code) {
        response= RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .headers(headersMap)
                .body(postbodycontent)
                .patch(apiUrl)
                .then().log().all()
                .assertThat().statusCode(code);
        System.out.println("Response :"+response.extract().body().asString());
    }
}
