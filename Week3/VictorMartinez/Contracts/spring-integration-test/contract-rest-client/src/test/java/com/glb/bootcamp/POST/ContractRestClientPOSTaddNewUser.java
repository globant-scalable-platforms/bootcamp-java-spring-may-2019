package com.glb.bootcamp.POST;

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
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:contract-rest-service:+:stubs:8100"})

public class ContractRestClientPOSTaddNewUser {


        @StubRunnerPort("contract-rest-service")
        private int port;

        @Test
        public void add_customer_from_service_contract_by_id() throws  Exception {

            JSONObject customerJsonObject = new JSONObject();
            customerJsonObject.put("id", 4L);
            customerJsonObject.put("name", "Felipe");
            customerJsonObject.put("surname", "Martinez");


            //Customer customer = new Customer( 4L, "Felipe", "Matinez");
            RestTemplate request = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> Query = new HttpEntity<String>(customerJsonObject.toString(),headers);

            /*this.mvc.perform(post("http://localhost:"+port+"/customer/id")
                    .accept(MediaType.APPLICATION_JSON) //.contentType(MediaType.APPLICATION_JSON)
                    .content(customerJsonObject.toString()))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(jsonPath("$.id").value(4L))
                    .andExpect(jsonPath("$.name").value("Felipe"))
                    .andExpect(jsonPath("$.surname").value("Martinez"));
            */
            ResponseEntity<Customer> entity =request.exchange("http://localhost:"+port+"/customer/id",
                    HttpMethod.POST,
                    Query,
                    Customer.class);
            // then:
            BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
            BDDAssertions.then(entity.getBody().getId()).isEqualTo(4l);
            BDDAssertions.then(entity.getBody().getName()).isEqualTo("Felipe");
            BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Martinez");

        }
}
