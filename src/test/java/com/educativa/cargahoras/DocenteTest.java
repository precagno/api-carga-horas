package com.educativa.cargahoras;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.services.DocenteService;

import static org.assertj.core.api.Assertions.assertThat;

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
		Docente docente = this.createDocenteEntity();
		int idDoc = docente.getIdDocente();
		Docente docFound=this.docenteService.getDocenteById(idDoc);
		String nombre=docente.getNombre();
		int antiguedad=docente.getAntiguedad();
		
		assertThat(this.docenteService.cantDocentes())
		.isGreaterThan(0)
		.isEqualTo(1);
		
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
	
	@Test
	public void getDocenteTest(){
		this.createDocenteEntity();
		Docente docente=this.docenteService.getDocenteByName("Pablo");
		
		assertThat(docente).
			isNotNull();
		
		assertThat(docente.getNombre()).isEqualTo("Pablo");
		assertThat(docente.getApellido()).isEqualTo("Recagno");
	}
	
	@Test
	public void updateDocenteTest(){
		
	}
	
	@Test
	public void deleteDocenteTest(){
		
	}

	/////////////Private methods
	@Before
	public void deleteAllDocentes(){
		this.docenteService.deleteAllDocentes();
	}
	
	private Docente createDocenteEntity(){
		Docente docente=new Docente();
		
		docente.setNombre("Pablo");
		docente.setApellido("Recagno");
		docente.setEdad(30);
		docente.setDireccion("Segurola 1325");
		docente.setNacionalidad("Argentino");
		docente.setAntiguedad(6);
		docente.setPuntaje(30.5);
		
		return this.docenteService.createDocente(docente);
	}
}