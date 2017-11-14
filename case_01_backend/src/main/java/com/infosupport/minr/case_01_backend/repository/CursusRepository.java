package com.infosupport.minr.case_01_backend.repository;

import com.infosupport.minr.case_01_backend.domain.Cursus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursusRepository extends JpaRepository<Cursus, Integer> {
}
