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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:contract-rest-service"})
@AutoConfigureMockMvc
@DirtiesContext
public class ContractRestClientPOSTnewUserById {

    @StubRunnerPort("contract-rest-service")
    private int port= 8100;

    @Autowired
    private MockMvc mvc;

    @Test
    public void add_customer_from_service_contract_by_id() throws  Exception {

        JSONObject customerJsonObject = new JSONObject();
        customerJsonObject.put("id", 4L);
        customerJsonObject.put("name", "William");
        customerJsonObject.put("surname", "Diaz");

        this.mvc.perform(post("http://localhost:"+port+"/customer/id")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJsonObject.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(4L))
                .andExpect(jsonPath("$.name").value("William"))
                .andExpect(jsonPath("$.surname").value("Diaz"));

    }

}
