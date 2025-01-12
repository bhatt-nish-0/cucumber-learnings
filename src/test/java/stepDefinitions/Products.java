package stepDefinitions;

//import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
//import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
//import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import groovy.json.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import org.json.simple.JSONObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
public class Products {

    public JSONObject jsonObject;
    public ResponseBody body;

    public RequestSpecification httpRequest;
    public Response response;

    public int responseCode;
    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";

    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
        }
    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        System.out.println("what?");
        responseCode = response.getStatusCode();
        assertEquals(200,responseCode);
    }

    @Then("I verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is_first_product_rate(String FirstProductRate) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(FirstProductRate);
        body = response.getBody();

        String responseBody = body.asString();

        JsonPath jsonPath = response.jsonPath();

        String s = jsonPath.getJsonObject("rating[0].rate").toString();

        System.out.println("nish printing");
        System.out.println(s);
        assertEquals(FirstProductRate,s);
    }


    @Given("I hit the url of post product api endpoint")
    public void iHitTheUrlOfPostProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        jsonObject = new JSONObject();


    }

    @And("I pass the request body of product title {}")
    public void iPassTheRequestBodyOfProductTitleProductTitle(String productTitle) {
        jsonObject.put("title",productTitle);
        jsonObject.put("price",3.9567);
        jsonObject.put("description","test");
        jsonObject.put("image","shoes");
        jsonObject.put("category","x");

        System.out.println(jsonObject.toJSONString());
        httpRequest.body(jsonObject.toJSONString());
        Response response1 = httpRequest.post("products");

        ResponseBody body = response1.getBody();
        System.out.println(response1.getStatusLine());
        System.out.println(body.asString());
    }

    @Given("the following JSON data:")
    public void theFollowingJsonData(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        MyPojo pojo = objectMapper.readValue(json, MyPojo.class);
        System.out.println("Test: " + pojo.getTest());
        System.out.println("A.B: " + pojo.getA().getB());
        System.out.println("C:" + pojo.getC());
    }

    @Given("some parameters")
    public void someParameters(List<Map<String,String>> x) throws JsonProcessingException {

        //System.out.println(x);
        //System.out.println(x.get(0));
        Map<String, String> data = x.get(0);

        String a1 = data.get("a");
        String a2 = data.get("acd");
        String a3 = data.get("bcd");
        String a4 = data.get("ord");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        Test t = new Test();
        t.setA(a1);
        t.setAcd(a2);
        t.setBcd(Integer.parseInt(a3));
        List<String> x2 = Arrays.asList(a4.split(","));
        t.setOrd(x2);

        System.out.println("---------------------");
        System.out.println(t);
        System.out.println("---------------------");

    }



    @Then("nothing")
    public void nothing() {
        System.out.println("nothing");
    }
}

class Test {
    private String a;
    private String acd;
    private int bcd;
    private List<String> ord;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getAcd() {
        return acd;
    }

    public void setAcd(String acd) {
        this.acd = acd;
    }

    public int getBcd() {
        return bcd;
    }

    public void setBcd(int bcd) {
        this.bcd = bcd;
    }

    public List<String> getOrd() {
        return ord;
    }

    public void setOrd(List<String> ord) {
        this.ord = ord;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a='" + a + '\'' +
                ", acd='" + acd + '\'' +
                ", bcd=" + bcd +
                ", ord=" + ord +
                '}';
    }
}
