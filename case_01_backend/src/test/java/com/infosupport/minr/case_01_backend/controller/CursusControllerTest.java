package com.infosupport.minr.case_01_backend.controller;

import com.infosupport.minr.case_01_backend.domain.Cursus;
import com.infosupport.minr.case_01_backend.service.CursusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CursusController.class)
public class CursusControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CursusService cursusService;

    @Test
    public void getCursuses() throws Exception {

        given(cursusService.findCursuses()).willReturn(Collections.checkedList(
                Arrays.asList(
                        new Cursus("Cursus 1", "sd", "4 uur", "2017-08-01"),
                        new Cursus("Cursus 2", "sd", "4 uur", "2017-08-01")
                ),
                Cursus.class
        ));

        mvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8081/cursuses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[{\"id\":0,\"title\":\"Cursus 1\",\"cursusCode\":\"sd\",\"duration\":\"4 uur\",\"startDate\":\"2017-08-01\",\"cursistList\":[]},{\"id\":0,\"title\":\"Cursus 2\",\"cursusCode\":\"sd\",\"duration\":\"4 uur\",\"startDate\":\"2017-08-01\",\"cursistList\":[]}]"));

    }
}
