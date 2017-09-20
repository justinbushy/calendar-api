package com.example.calendarapi;

import com.example.calendarapi.controllers.UserController;
import com.example.calendarapi.models.User;
import com.example.calendarapi.models.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.*;
//import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserDao userDao;


    @Test
    public void correctJSONOnRegister() throws Exception {

		User user = new User("jbush@gmail.com", "Jordan", "Bush", "jordanbush", "passs");


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

		mvc.perform(put("/register")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void errorNoJSONRegister() throws Exception {

        mvc.perform(put("/register"))
                .andExpect(status().isBadRequest());
    }
}
