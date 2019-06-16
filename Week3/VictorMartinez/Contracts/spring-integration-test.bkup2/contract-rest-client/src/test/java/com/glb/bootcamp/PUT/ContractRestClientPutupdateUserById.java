package com.glb.bootcamp.PUT;

import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.globant.bootcamp:contract-rest-service")
public class ContractRestClientPutupdateUserById {



        @StubRunnerPort("contract-rest-service")
        private int port = 8100;


        @Test
        public void update_customer_from_service_contract() {
            // given:
            RestTemplate restTemplate = new RestTemplate();

            JSONObject updateUser = new JSONObject();
            updateUser.put("id", 1);
            updateUser.put("name", "Mike");
            updateUser.put("surname", "Gutierrez");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(updateUser.toString(), headers);
            // when:
            restTemplate.postForEntity("http://localhost:"+port+"/customer/name/id/1", request, Customer.class);

            ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:"+port+"/customer/id/1", Customer.class);
            // then:
            BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
            BDDAssertions.then(entity.getBody().getId()).isEqualTo(1l);
            BDDAssertions.then(entity.getBody().getName()).isEqualTo("Mike");
            BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Gutierrez");

        }


}



