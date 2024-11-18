package com.copilot.user.mgmt.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    private final String username = "testuser";

    @Test
    public void testGenerateToken() {
        String token = jwtUtil.generateToken(username);
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    public void testValidateToken() {
        String token = jwtUtil.generateToken(username);
        assertTrue(jwtUtil.validateToken(token, username));
    }
}