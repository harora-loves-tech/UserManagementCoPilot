
package com.copilot.user.mgmt.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.copilot.user.mgmt.dto.AuthenticationRequestDTO;
import com.copilot.user.mgmt.service.UserService;
import com.copilot.user.mgmt.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthenticationController authenticationController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testAuthenticateUser_Success() throws Exception {
        AuthenticationRequestDTO requestDTO = new AuthenticationRequestDTO();
        requestDTO.setUsername("testuser@gmail.com");
        requestDTO.setPassword("testpassword");

        when(userService.authenticateUser(any(AuthenticationRequestDTO.class))).thenReturn(true);
        when(jwtUtil.generateToken(any(String.class))).thenReturn("testtoken");

        mockMvc.perform(post("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("testtoken"));
    }

    @Test
    public void testAuthenticateUser_Failure() throws Exception {
        AuthenticationRequestDTO requestDTO = new AuthenticationRequestDTO();
        requestDTO.setUsername("testuser@gmail.com");
        requestDTO.setPassword("wrongpassword");

        when(userService.authenticateUser(any(AuthenticationRequestDTO.class))).thenReturn(false);

        mockMvc.perform(post("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Invalid username or password"));
    }
    
    // Add test for validating token
    @Test
    public void testValidateToken_Success() throws Exception {
    	        String token = "test token";
				String userName = "testuser";
				when(jwtUtil.validateToken(token, userName)).thenReturn(true);	
				mockMvc.perform(post("/validate/{userName}", userName)
                        .header("Authorization", token))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Token is valid"));
    }
    
    @Test
    public void testValidateToken_Failure() throws Exception {
    	        String token = "test token";
    	                        String userName = "testuser";
    	                        when(jwtUtil.validateToken(token, userName)).thenReturn(false);
    	                        
    }   
}
