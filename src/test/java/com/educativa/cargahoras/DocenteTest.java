package com.educativa.cargahoras;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.services.DocenteService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocenteTest {

	@Autowired
	private DocenteService docenteService;

	//@Test
	public void contextLoads() {
	}

	@Test
	public void createDocenteTest(){
		Docente docente = new Docente();
		docente.setNombre("Pablo");
		docente.setApellido("Recagno");
		docente.setEdad(30);
		docente.setDireccion("Segurola 1325");
		docente.setNacionalidad("Argentino");
		docente.setAntiguedad(6);
		docente.setPuntaje(30.5);
		Docente doc1 = this.docenteService.createDocente(docente);
	}

	@Before
	@After
	public void deleteAllDocentes(){
		this.docenteService.deleteAllDocentes();
	}
}