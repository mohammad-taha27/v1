package com.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorld.class)
public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception{
        mockMvc.perform(get(("/")))
                .andExpect(status().isOk())
                .andExpect(content().string("hell"));
    }

    @Test
    void testWorldEndpoint() throws Exception {
        mockMvc.perform(get("/world"))
                .andExpect(status().isOk())
                .andExpect(content().string("world"));
    }

}
