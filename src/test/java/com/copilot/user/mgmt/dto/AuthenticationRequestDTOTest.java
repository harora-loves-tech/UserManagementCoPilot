package com.copilot.user.mgmt.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationRequestDTOTest {

    @Test
    public void testNoArgsConstructor() {
        AuthenticationRequestDTO dto = new AuthenticationRequestDTO();
        assertNotNull(dto);
    }

    @Test
    public void testAllArgsConstructor() {
        String username = "testuser";
        String password = "testpass";
        AuthenticationRequestDTO dto = new AuthenticationRequestDTO(username, password);
        assertEquals(username, dto.getUsername());
        assertEquals(password, dto.getPassword());
    }

    @Test
    public void testSettersAndGetters() {
        AuthenticationRequestDTO dto = new AuthenticationRequestDTO();
        String username = "testuser";
        String password = "testpass";
        dto.setUsername(username);
        dto.setPassword(password);
        assertEquals(username, dto.getUsername());
        assertEquals(password, dto.getPassword());
    }
    
}
