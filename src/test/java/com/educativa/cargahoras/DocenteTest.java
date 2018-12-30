package com.educativa.cargahoras;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.services.DocenteService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
		.isGreaterThan(30d);
	}
	
	@Test
	public void getDocenteTest(){
		this.createDocenteEntity();
		Docente docente=this.docenteService.getDocenteByName("Pablo");
		
		assertThat(docente).isNotNull();
		assertThat(docente.getNombre()).isNotEmpty().isEqualTo("Pablo");
		assertThat(docente.getApellido()).isNotEmpty().isEqualTo("Recagno");
	}

	@Test
    public void getDocenteExceptionTest(){
        assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(()->{
            this.docenteService.getDocenteById(-1);
        });
    }
	
	@Test
	public void updateDocenteTest(){
        int idDocente = this.createDocenteEntity().getIdDocente();

        Docente docenteAux = new Docente();
        String nombre = "Raul";
        docenteAux.setNombre(nombre);
        String apellido = "Antares";
        docenteAux.setApellido(apellido);

        this.docenteService.updateDocenteById(idDocente,docenteAux);

        Docente docenteUpdated = this.docenteService.getDocenteById(idDocente);

        assertThat(docenteUpdated).isNotNull();
        assertThat(docenteUpdated.getNombre()).isNotEmpty().isEqualTo(nombre);
        assertThat(docenteUpdated.getApellido()).isNotEmpty().isEqualTo(apellido);
    }
	
	@Test
	public void deleteDocenteTest(){
        int idDocente = this.createDocenteEntity().getIdDocente();
        int idDocenteDeleted = this.docenteService.deleteDocenteById(idDocente);

        assertThat(idDocenteDeleted).isEqualTo(idDocente).isGreaterThan(0);
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
		docente.setNacionalidad("argentino");
		docente.setAntiguedad(6);
		docente.setPuntaje(30.5);
		
		return this.docenteService.createDocente(docente);
	}
}