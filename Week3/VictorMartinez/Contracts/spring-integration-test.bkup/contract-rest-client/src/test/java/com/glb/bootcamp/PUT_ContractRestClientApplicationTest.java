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
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringRunner.class)
@SpringBootTest

public class PUT_ContractRestClientApplicationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static HttpHeaders headers;
    private static HttpHeaders headers2;

    private static String updatePersonUrlById = "";
    private static String updatePersonUrlByName = "";

    private static JSONObject personJsonObjectById;
    private static JSONObject personJsonObjectByName;


    @BeforeClass
    public static void runBeforeAllTestMethods() {
        updatePersonUrlById = "http://localhost:8000/customer/{id}";
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        personJsonObjectById = new JSONObject();

        try {
            personJsonObjectById.put("id", 5);
            personJsonObjectById.put("name", "Luis");
            personJsonObjectById.put("surname", "Jaimes");
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.globant.bootcamp", "contract-rest-service", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void update_customer_from_service_contract_by_id() {
        // given:
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(personJsonObjectById.toString(), headers);
        // when:


        ResponseEntity<Customer> entity = restTemplate.exchange("http://localhost:8100/customer/5", HttpMethod.PUT, request, Customer.class);
        // then:
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody().getId()).isEqualTo(5l);
        BDDAssertions.then(entity.getBody().getName()).isEqualTo("Luis");
        BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Jaimes");

    }

}