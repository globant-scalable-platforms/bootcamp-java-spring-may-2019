package bootcamp.springrest;

import bootcamp.springrest.roleCheck.controller.RoleCheckController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoleCheckController.class)
@ComponentScan("bootcamp.springrest.roleCheck")
public class RoleCheckTest{

    @Autowired
    MockMvc mvc;

    @Test
    public void testAdminRole() throws Exception{
        mvc.perform(get("/role-check/get-users")
                .header("roles", "admin, user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdminRoleCaseSensitive() throws Exception{
        mvc.perform(get("/role-check/get-users")
                .header("roles", "AdMin, user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testNonAdminRole() throws Exception{
        mvc.perform(get("/role-check/get-users")
                .header("roles", "user"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testNoHeader() throws Exception{
        mvc.perform(get("/role-check/get-users"))
                .andExpect(status().isBadRequest());
    }
}
