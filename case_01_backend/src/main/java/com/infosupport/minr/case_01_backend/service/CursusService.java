package com.infosupport.minr.case_01_backend.service;

import com.infosupport.minr.case_01_backend.repository.CursusRepository;
import com.infosupport.minr.case_01_backend.domain.Cursus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursusService {
    @Autowired
    private CursusRepository cursusRepository;

    public List<Cursus> findCursuses() {
        return cursusRepository.findAll();
    }

    public void add(Cursus cursus) {
        cursusRepository.save(cursus);
    }
}
