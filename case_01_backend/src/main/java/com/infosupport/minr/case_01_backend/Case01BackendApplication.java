package com.infosupport.minr.case_01_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Case01BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Case01BackendApplication.class, args);
	}

//	@Autowired
//	private CursusService cursusService;

	@Override
	public void run(String... args) throws Exception {
//		List<Cursus> cursuses = Arrays.asList(
//				new Cursus("Cursus 1", "sd", "4 uur", "2017-08-01"),
//				new Cursus("Cursus 2", "sd", "4 uur", "2017-08-01")
//		);
//
//		cursuses.forEach(cursusService::add);
	}

	@Bean
	@Scope(SCOPE_PROTOTYPE)
	public Logger logger(InjectionPoint ip) {
		return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
	}
}
