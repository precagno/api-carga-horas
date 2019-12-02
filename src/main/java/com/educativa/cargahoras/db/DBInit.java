package com.educativa.cargahoras.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.services.DocenteService;

@Configuration
public class DBInit implements CommandLineRunner{

	@Autowired
	private DocenteService docenteService;
	
	@Value("${db.data.fake}")
	private boolean fakeData;
	
	@Override
	public void run(String... args) throws Exception {
		if(this.fakeData) {
			createDocentes();
		}
	}

	private void createDocentes() {
		Docente docente1 = new Docente("German", "Cisco", 29, "Uruguay 2093", "argentino", 10, 40.5);
		Docente docente2 = new Docente("Luis", "Pernia", 22, "Valencia 125", "argentino", 1, 20d);
		Docente docente3 = new Docente("Elisa", "Sanchez", 40, "Valentin Alsina 125", "argentina", 20, 80d);
		Docente docente4 = new Docente("Ariel", "Zulpe", 35, "Zotrillo 691", "argentino", 12, 60d);
		
		//Ingresamos docentes
		this.docenteService.createDocente(docente1);
		this.docenteService.createDocente(docente2);
		this.docenteService.createDocente(docente3);
		this.docenteService.createDocente(docente4);
	}

}
