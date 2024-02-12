
package co.learning.springpetclinicdemo.controller;

import co.learning.springpetclinicdemo.service.OwnerService;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@WebMvcTest(OwnerController.class)
@Disabled("Not needed")
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Test
    public void testFindOwners() {
        try {
            mockMvc.perform(get("/owners/find"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("findOwners"));
        } catch (Exception e) {
            Fail.fail("Test threw error", e);
        }
    }

    @Test
    public void testAddOwner() throws Exception {
        mockMvc
                .perform(post("/owners/saveOwner")
                        .param("firstName","Mahi")
                        .param("lastName","Gill")
                        .param("address","Richmond")
                        .param("city","ON")
                        .param("telephone","9894738347"))
                .andExpect(status().is3xxRedirection());
    }
}

