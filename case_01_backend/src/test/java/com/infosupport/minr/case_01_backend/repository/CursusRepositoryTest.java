package com.infosupport.minr.case_01_backend.repository;

import com.infosupport.minr.case_01_backend.domain.Cursus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursusRepositoryTest {
    @Autowired
    private CursusRepository cursusRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void findCursusesExpectCursuses() {
        em.persist(new Cursus("Cursus 1", "sd", "4 uur", "2017-08-01"));
        em.flush();
        em.clear();

        List<Cursus> cursus = cursusRepository.findAll();

        assertThat(cursus.get(0).getTitle(), is("Cursus 1"));
    }
}
