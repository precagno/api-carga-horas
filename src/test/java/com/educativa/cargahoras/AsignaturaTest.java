package com.educativa.cargahoras;

import com.educativa.cargahoras.entities.Asignatura;
import com.educativa.cargahoras.repositories.AsignaturaRepository;

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

	@Test
	public void contextLoads() {
	}

	//@Test
	public void cargarAsignaturasTest(){

	}

	//@Before
	//@After
	public void truncateTable(){
		this.repo.deleteAll();
	}
}