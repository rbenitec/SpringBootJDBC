package com.example.rbenitec.springbootapp.repository;

import java.util.List;

import com.example.rbenitec.springbootapp.entities.Producto;

public interface ProductoRepository {
	//Listar
	public List<Producto> listar() throws Exception;
	
	//Registrar
	public void registrar(Producto producto) throws Exception;
	
	//Modificar
	public void modificar(Long id,String nombreProducto) throws Exception;
	
	//Eliminar
	public void eliminar(Long id) throws Exception;
	
	//Buscar por nombre
	public List<Producto> findByName(String nombre) throws Exception;
	
	//Buscar por ID
	public Producto findById(Long id) throws Exception;
	
}
