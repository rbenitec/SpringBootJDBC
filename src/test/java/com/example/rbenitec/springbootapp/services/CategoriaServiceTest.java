package com.example.rbenitec.springbootapp.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rbenitec.springbootapp.entities.Categoria;

@SpringBootTest
public class CategoriaServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(CategoriaServiceTest.class);
	
	@Autowired
	CategoriaService categoriaService;
	
	@Test
	void test() throws Exception{
		List<Categoria> cats = categoriaService.listar();
		
		log.info(">>>>>" +cats.toString());
		assertThat(cats.isEmpty(), is(false));
	}
	

	//Metodo test del listado de categoria
	@Test
	void testRunner() throws Exception{
		List<Categoria> lis = categoriaService.listar();
		
		log.info("Recorrido, con for: ");
		for(Categoria x : lis) {
			log.info(x.toString());
		}
		log.info("Recorrdio con stream: ");
		lis.stream().forEach(item -> log.info(item.toString()));
		
	}
	
}
