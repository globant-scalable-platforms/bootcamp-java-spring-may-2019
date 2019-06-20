package com.glb.bootcamp.PUT;


import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import wiremock.net.minidev.json.JSONObject;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:contract-rest-service:+:stubs"})

public class ContractRestClientPUTupdateUser {


    @StubRunnerPort("contract-rest-service")
    private int port;

    @Test
    public void update_customer_from_service_contract_by_id() throws  Exception {


        JSONObject customerJsonObject = new JSONObject();
        customerJsonObject.put("id", 3L);
        customerJsonObject.put("name", "Daniel");
        customerJsonObject.put("surname", "Gutierrez");

        //Customer updateCustomer = new Customer(1L, "Mike", "Gutierrez");

        RestTemplate putUpdateUserRequest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> Query = new HttpEntity<String>(customerJsonObject.toString(),headers);


        putUpdateUserRequest.exchange("http://localhost:"+port+"/customer/id/3", HttpMethod.PUT, Query, String.class);
        ResponseEntity<Customer> entity = putUpdateUserRequest.getForEntity("http://localhost:"+port+"/customer/id/3", Customer.class);

        // then:
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody().getId()).isEqualTo(3l);
        BDDAssertions.then(entity.getBody().getName()).isEqualTo("Daniel");
        BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Gutierrez");

    }



}
