package org.example.springunittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ApiIntegrationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void veriCekmeTesti() {
        ResponseEntity<Map> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", Map.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().containsKey("userId"));
        assertTrue(response.getBody().containsKey("id"));
        assertTrue(response.getBody().containsKey("title"));
        assertTrue(response.getBody().containsKey("body"));
    }

    @Test
    public void veriGondermeTesti() {
        Map<String, Object> request = new HashMap<>();
        request.put("userId", 1);
        request.put("title", "Test Başlık");
        request.put("body", "Test İçerik");

        ResponseEntity<Map> response = restTemplate.postForEntity("https://jsonplaceholder.typicode.com/posts", request, Map.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Test Başlık", response.getBody().get("title"));
        assertEquals("Test İçerik", response.getBody().get("body"));
    }
}

