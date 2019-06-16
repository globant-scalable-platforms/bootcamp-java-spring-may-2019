package com.glb.bootcamp.POST;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:contract-rest-service"})
@AutoConfigureMockMvc
public class ContractRestClientPOSTnewUserByName {

    @StubRunnerPort("contract-rest-service")
    private int port = 8100;


    @Autowired
    private MockMvc mvc;

    @Test
    public void add_customer_from_service_contract_by_name() throws  Exception {

        JSONObject customerJsonObject = new JSONObject();
        customerJsonObject.put("id", 5L);
        customerJsonObject.put("name", "Thomas");
        customerJsonObject.put("surname", "Pelaez");

        this.mvc.perform(post("http://localhost:"+port+"/customer/name")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJsonObject.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(5L))
                .andExpect(jsonPath("$.name").value("Thomas"))
                .andExpect(jsonPath("$.surname").value("Pelaez"));
    }


}
