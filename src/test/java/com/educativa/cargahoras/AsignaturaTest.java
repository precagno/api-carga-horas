package com.educativa.cargahoras;

import com.educativa.cargahoras.model.Asignatura;
import com.educativa.cargahoras.repository.AsignaturaRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsignaturaTest {

	@Autowired
	private AsignaturaRepository repo;

	//@Test
	public void contextLoads() {
	}

	@Test
	public void cargarAsignaturasTest(){
		Asignatura asig = new Asignatura();
		asig.setNombre_asignatura("Literatura Americana");
		Asignatura save = this.repo.save(asig);

		assertEquals(save.getNombre_asignatura(),"Literatura Americana");
		assertTrue(this.repo.count() == 1);
	}

	@Before
	@After
	public void truncateTable(){
		this.repo.deleteAll();
	}
}