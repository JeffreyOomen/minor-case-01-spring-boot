package com.infosupport.minr.case_01_backend.services;

import com.infosupport.minr.case_01_backend.domain.Cursus;
import com.infosupport.minr.case_01_backend.repository.CursusRepository;
import com.infosupport.minr.case_01_backend.service.CursusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursusServiceTest {
    // NOTE: our cursusService is an integration test with the repository since it contains only a single line to our repository

    @Autowired
    private CursusRepository cursusRepository;

    @Autowired
    private CursusService cursusService;

    @Autowired
    private TestEntityManager em;

    @Test
    public void findCursusesExpectCursuses() {
        em.persist(new Cursus("Cursus 1", "sd", "4 uur", "2017-08-01"));
        em.flush();
        em.clear();

        List<Cursus> cursus = cursusService.findCursuses();

        assertThat(cursus.get(0).getTitle(), is("Cursus 1"));
    }
}
