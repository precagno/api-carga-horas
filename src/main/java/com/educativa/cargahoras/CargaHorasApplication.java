package com.educativa.cargahoras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CargaHorasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargaHorasApplication.class, args);
	}
}