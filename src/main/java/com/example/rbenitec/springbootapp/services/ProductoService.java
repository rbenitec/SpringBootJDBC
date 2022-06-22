package com.example.rbenitec.springbootapp.services;

import java.util.List;

import com.example.rbenitec.springbootapp.entities.Producto;

public interface ProductoService {
	public List<Producto> listar() throws Exception;
	
	public void registrar(Producto producto) throws Exception;
	
	public void actualizar(Long id, String nombreProducto) throws Exception;
	
	public void eliminar(Long id) throws Exception;
}
