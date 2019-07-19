package bootcamp.springrest;

import bootcamp.springrest.dateRange.controller.DateRangeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DateRangeController.class)
public class DateRangeTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testValidRange()throws Exception{
        String json = "{\"fromDate\": \"2008-12-19\", \"toDate\": \"2008-12-20\"}";

        mvc.perform(post("/date/check-range")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Valid date range "));
    }

    @Test
    public void testInvalidRange() throws Exception{
        String json = "{\"fromDate\": \"2008-12-22\", \"toDate\": \"2008-12-20\"}";

        mvc.perform(post("/date/check-range")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid date range"));
    }

    @Test
    public void testInvalidFormat() throws Exception{
        String json = "{\"fromDate\": \"thisisnotadate\", \"toDate\": \"2008-12-20\"}";

        mvc.perform(post("/date/check-range")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The date format was not recognized. Please use yyyy-MM-dd \n" +
                        "Unparseable date: \"thisisnotadate\""));
    }
}
