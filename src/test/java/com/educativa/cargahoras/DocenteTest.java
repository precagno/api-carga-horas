package com.educativa.cargahoras;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.services.DocenteService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
		String nombre = "Pablo";
		String apellido = "Recagno";
		int antiguedad = 6;
		double puntaje = 30.5;
		
		docente.setNombre(nombre);
		docente.setApellido(apellido);
		docente.setEdad(30);
		docente.setDireccion("Segurola 1325");
		docente.setNacionalidad("Argentino");
		docente.setAntiguedad(antiguedad);
		docente.setPuntaje(puntaje);
		
		int idDoc = this.docenteService.createDocente(docente).getIdDocente();
		Docente docFound=this.docenteService.getDocenteById(idDoc);
		
		assertThat(this.docenteService.cantDocentes())
		.isGreaterThan(0)
		.isEqualTo(1)
		;
		
		assertThat(docFound.getNombre())
			.isEqualTo(nombre)
			.hasSize(nombre.length());
		
		assertThat(docFound.getAntiguedad())
		.isNotNull()
		.isGreaterThanOrEqualTo(antiguedad);
		
		assertThat(docFound.getPuntaje())
		.isNotNull()
		.isGreaterThan(30d)
		;
	}

	@Before
	@After
	public void deleteAllDocentes(){
		this.docenteService.deleteAllDocentes();
	}
}