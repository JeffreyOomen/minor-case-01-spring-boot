package com.infosupport.minr.case_01_backend;

import com.infosupport.minr.case_01_backend.service.CursusService;
import com.infosupport.minr.case_01_backend.domain.Cursus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Case01BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Case01BackendApplication.class, args);
	}

	@Autowired
	private CursusService cursusService;

	@Override
	public void run(String... args) throws Exception {
		List<Cursus> cursuses = Arrays.asList(
				new Cursus("Cursus 1", "sd", "4 uur", "2017-08-01"),
				new Cursus("Cursus 2", "sd", "4 uur", "2017-08-01")
		);

		cursuses.forEach(cursusService::add);
	}
}
