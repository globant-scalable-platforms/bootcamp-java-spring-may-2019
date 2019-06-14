package com.glb.bootcamp;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class POST_ContractRestClientApplicationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static HttpHeaders headers;

    private static String createPersonUrl="";
    private static String createPersonUrlByName="";

    private static JSONObject personJsonObject;
    private static JSONObject personJsonObjectByName;

    @BeforeClass
    public static void runBeforeAllTestMethods(){
        createPersonUrl = "http://localhost:8000/customer" ;
        createPersonUrlByName= "http://localhost:8000/customer/{name}" ;

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        try {
            personJsonObject.put("id", 4);
            personJsonObject.put("name", "William");
            personJsonObject.put("surname", "Diaz");
        }catch(Exception ex){
            ex.printStackTrace();
        }

        personJsonObjectByName = new JSONObject();
        try {
            personJsonObjectByName.put("id", 5);
            personJsonObjectByName.put("name", "Luis");
            personJsonObjectByName.put("surname", "Jackson");
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.globant.bootcamp", "contract-rest-service", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);


    @Test
    public void add_customer_from_service_contract_By_Id() {
        // given:
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        // when:
        ResponseEntity<Customer> entity = restTemplate.postForEntity("http://localhost:8100/customer/4", request, Customer.class);

        // then:
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody().getId()).isEqualTo(4l);
        BDDAssertions.then(entity.getBody().getName()).isEqualTo("William");
        BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Diaz");

    }

    @Test
    public void add_customer_from_service_contract_By_Name() {
        // given:
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(personJsonObjectByName.toString(), headers);
        // when:
        ResponseEntity<Customer> entity = restTemplate.postForEntity("http://localhost:8100/customer/Luis", request, Customer.class);

        // then:
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody().getId()).isEqualTo(5l);
        BDDAssertions.then(entity.getBody().getName()).isEqualTo("Luis");
        BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Jackson");

    }

}
