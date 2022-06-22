package com.example.rbenitec.springbootapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rbenitec.springbootapp.entities.Producto;
import com.example.rbenitec.springbootapp.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listar() throws Exception {
		log.info("Call Listar()");
		return productoRepository.listar();
	}

	@Override
	public void registrar(Producto producto) throws Exception {
		log.info("Call Registrar: (Producto = "+producto+")");
		productoRepository.registrar(producto);
		
	}

	@Override
	public void eliminar(Long id) throws Exception {
		log.info("Call delete: (Id= " +id+ ")");
		productoRepository.eliminar(id);
		
	}

	@Override
	public void actualizar(Long id, String nombreProducto) throws Exception {
		log.info("Call Update: "+id+"");
		productoRepository.modificar(id, nombreProducto);
		
	}

}
