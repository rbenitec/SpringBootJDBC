package com.example.rbenitec.springbootapp.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rbenitec.springbootapp.entities.Producto;

@SpringBootTest
public class ProductoServiceTest {
	
	private static Logger log = LoggerFactory.getLogger(ProductoServiceTest.class);
	
	@Autowired
	private ProductoService productoService;

	//Test de listar
	@Test
	public void testList() throws Exception{
		List<Producto> lis = productoService.listar();
		log.info("Listado: "+ lis);
		
		assertThat(lis.isEmpty(), is(false));
	}
	
	// -- Test de Registrar
	
	@Test
	public void testRegister() throws Exception{
		List<Producto> listProductLater = productoService.listar();
		int cantProdLater= listProductLater.size();
		
		Producto p = new Producto();
		p.setCategorias_id(1L);
		p.setNombre("AMD");
		p.setDescripcion("AMD X150");
		p.setPrecio(365.85);
		p.setStock(5);
		productoService.registrar(p);
		List<Producto> listProductNow = productoService.listar();
		int cantProdNow = listProductNow.size();
		
		assertThat(cantProdNow-cantProdLater, is(1));
		
	}
	
	// -- Test de Eliminar
	@Test
	public void testDelete() throws Exception{
//		Long deleteId = 26L;
//		
//		productoService.Eliminar(deleteId);
//		
//		List<Producto> lis = productoService.listar();
//		for(Producto x: lis) {
//			assertThat(x.getId()==deleteId, is(false));
//		}
		
		List<Producto> productos = productoService.listar();
		int totalAntes = productos.size();
		if (productos.isEmpty()) {
			return; // test pass
		}
		Producto ultimoProducto = productos.get(productos.size()-1);
		productoService.eliminar(ultimoProducto.getId());
		productos = productoService.listar();
		int totalDespues = productos.size();
		assertThat(totalAntes - totalDespues, is(1));
			
	}
	
	@Test
	public void testBuscarPorNombre() throws Exception {
		List<Producto> lis = productoService.findByName("AMD");
		log.info("Print by productos");
		
		lis.stream().forEach(p -> log.info(p.toString()));
		
		assertThat(lis.isEmpty(), is(false));
		
	}
	
	@Test
	public void testActualizar() throws Exception{
		//Actualizar el nombre del producto
		Long id = 26L;
		String newName= "Sonix";
		productoService.actualizar(id, newName);
		//Buscar el producto
		
		List<Producto> changeProduct = productoService.findByName(newName);
		
		//Verificar que el nombre ha sido cambiado
		
		assertThat(changeProduct.isEmpty(), is(false));
		
	}
	
	@Test
	public void findById() throws Exception{
		//Encontrar el producto por Id
		Long id = 26L;
		Producto p = productoService.findById(id);
		//Validar que haya encontrado el producto
		assertThat(p.getId()!=id, is(false));
	}
	
}
