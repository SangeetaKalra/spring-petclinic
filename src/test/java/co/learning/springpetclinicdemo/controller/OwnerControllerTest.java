package co.learning.springpetclinicdemo.controller;


import co.learning.springpetclinicdemo.entity.Owner;
import co.learning.springpetclinicdemo.service.OwnerService;
import co.learning.springpetclinicdemo.testsupport.factories.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(OwnerController.class)
public class OwnerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    void setUp() {

        List<Owner> owners = Arrays.asList(
                OwnerFactory.createJohnDoe(), OwnerFactory.createJaneSmith());
        Mockito.when(ownerService.getAllOwners()).thenReturn(owners);

    }


    @Test
    public void testGetAllOwners() throws Exception {
        // Mocking the service response


        // Performing the GET request and asserting the response
        mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("listOwners"))
               .andExpect(view().name("findOwners"));


    }

}
