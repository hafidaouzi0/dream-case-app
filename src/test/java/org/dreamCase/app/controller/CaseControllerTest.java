package org.dreamCase.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dreamCase.app.entity.Case;
import org.dreamCase.app.service.CaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;




import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CaseController.class)
class CaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CaseService caseService;

    Case aCase1;
    Case aCase2;

    List<Case> cases=new ArrayList<>();


    @BeforeEach
    void setUp() {
        aCase1=new Case(1L,LocalDateTime.now(),LocalDateTime.now(),"Amazon","description service test");
        aCase2=new Case(2L,LocalDateTime.now(),LocalDateTime.now(),"Azure","description service test 2");
        cases.add(aCase1);
        cases.add(aCase2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCase() {
    }

    @Test
    void updateCase() {
    }

    @Test
    void testGetCase() throws Exception {

        when(caseService.getCase(aCase1.getCaseId())).thenReturn(aCase1);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cases/{id}",aCase1.getCaseId()))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    void testDeleteCase() throws Exception {

        when(caseService.deleteCase(aCase1.getCaseId())).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cases/{id}",aCase1.getCaseId()))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void testGetAllCases() throws Exception {
        when(caseService.getAllCases()).thenReturn(cases);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cases"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}