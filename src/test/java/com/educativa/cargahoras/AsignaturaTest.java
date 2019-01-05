package com.educativa.cargahoras;

import com.educativa.cargahoras.entities.Asignatura;

import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.services.AsignaturaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsignaturaTest {

	@Autowired
	private AsignaturaService asignaturaService;

	//@Test
	public void contextLoads() {
	}

	@Test
	public void getAllAsignaturasTest(){
		List<Asignatura> asignaturas = this.asignaturaService.getAsignaturas();

		assertThat(asignaturas).isNotNull();
		assertThat(asignaturas.size()).isEqualTo(0);

		Asignatura asignaturaSaved=this.createAsignaturaEntity();

		asignaturas=this.asignaturaService.getAsignaturas();

		assertThat(asignaturas).isNotNull();
		assertThat(asignaturas.size()).isEqualTo(1);
		assertThat(asignaturas.get(0).getNombreAsignatura()).isEqualTo(asignaturaSaved.getNombreAsignatura());
	}

	@Test
	public void getAsignaturaByIdTest(){
		Asignatura asignaturaSaved = this.createAsignaturaEntity();
		Asignatura asignaturaById = this.asignaturaService.getAsignaturaById(asignaturaSaved.getIdAsignatura());

		assertThat(asignaturaById).isNotNull();
		assertThat(asignaturaById.getNombreAsignatura()).isEqualTo(asignaturaSaved.getNombreAsignatura());
	}

	@Test
	public void getAsignaturaExceptionTest(){
		assertThatExceptionOfType(ResourceNotFoundException.class)
				.isThrownBy(()->this.asignaturaService.getAsignaturaById(0));
	}

	@Test
	public void createAsignaturaTest(){
		Asignatura asignaturaSaved = this.createAsignaturaEntity();
		int idAsigSaved = asignaturaSaved.getIdAsignatura();
		Asignatura asigFound=this.asignaturaService.getAsignaturaById(idAsigSaved);
		String nombreAsignatura=asignaturaSaved.getNombreAsignatura();

		assertThat(this.asignaturaService.cantAsignaturas())
				.isGreaterThan(0)
				.isEqualTo(1)
				.isNotEqualTo(4);

		assertThat(asigFound.getNombreAsignatura())
				.isEqualTo(nombreAsignatura)
				.hasSize(nombreAsignatura.length());
	}

	@Test
	public void updateAsignaturaTest(){
		int idAsignatura = this.createAsignaturaEntity().getIdAsignatura();

		Asignatura asignaturaAux = new Asignatura();
		String nombreAsignatura = "Lengua y Literatura de America Latina";
		asignaturaAux.setNombreAsignatura(nombreAsignatura);

		this.asignaturaService.updateAsignatura(idAsignatura,asignaturaAux);

		Asignatura asignaturaUpdated = this.asignaturaService.getAsignaturaById(idAsignatura);

		assertThat(asignaturaUpdated).isNotNull();
		assertThat(asignaturaUpdated.getNombreAsignatura()).isNotEmpty().isEqualTo(nombreAsignatura);
	}

	@Test
	public void deleteAsignaturaTest(){
		Asignatura asignaturaSaved = this.createAsignaturaEntity();
		int idAsignaturaSaved=asignaturaSaved.getIdAsignatura();
		int asignaturaDeleted = this.asignaturaService.deleteAsignaturaById(idAsignaturaSaved);
		assertThat(asignaturaDeleted).isEqualTo(asignaturaSaved.getIdAsignatura());
	}

	@Before
	public void deleteAllAsignaturas(){
		this.asignaturaService.deleteAsignaturas();
	}

	/////////////Private methods
	private Asignatura createAsignaturaEntity(){
		Asignatura asignatura = new Asignatura();

		asignatura.setNombreAsignatura("Lengua y Literatura");

		return this.asignaturaService.createAsignatura(asignatura);
	}
}