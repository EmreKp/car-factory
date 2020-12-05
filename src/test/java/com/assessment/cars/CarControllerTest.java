package com.assessment.cars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cabrio() throws Exception {
        mockMvc.perform(get("/?type=cabrio"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'result':'Cabrio Car has produced.'}"));
    }

    @Test
    public void type_case_insensitive() throws Exception {
        mockMvc.perform(get("/?type=SedAn"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'result':'Sedan Car has produced.'}"));
    }

    @Test
    public void type_uppercase() throws Exception {
        mockMvc.perform(get("/?type=HATCHBACK"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'result':'Hatchback Car has produced.'}"));
    }

    @Test
    public void type_unspecified() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'error':'Please specify a car type'}"));
    }

    @Test
    public void type_unsupported() throws Exception {
        mockMvc.perform(get("/?type=foo"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().json("{'error':'Invalid type: foo'}"));
    }
}
