package com.ansh.restSpring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test Case for Signup
    @Test
    public void testsignupUser() throws Exception {
        // Prepare a request body for signup
        String signupRequest = """
                {
                    "username": "anshmehta",
                    "password": "1234"
                }
                """;

        // Send a POST request to /api/v1/signup
        mockMvc.perform(post("/api/v1/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(signupRequest))
                .andExpect(status().isOk()); // Expect HTTP 200 OK if signup is successful
    }

     // Test Case for Login
    @Test
    public void testLoginSuccess() throws Exception {
        // Prepare a request body for login
        String loginRequest = """
                {
                    "username": "anshmehta",
                    "password": "1234"
                }
                """;

        // Send a POST request to /api/v1/login
        mockMvc.perform(post("/api/v1/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginRequest))
                .andExpect(status().isOk()); // Expect HTTP 200 OK if login is successful
    }
}
