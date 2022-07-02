package com.example.rbenitec.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rbenitec.springbootapp.entities.Producto;
import com.example.rbenitec.springbootapp.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar() throws Exception{
		return productoService.listar();
	}
	
	//Buscar por Id
	
	@GetMapping("id/{id}")
	public Producto findById(@PathVariable("id") Long id) throws Exception{
		return productoService.findById(id);
	}
	//Buscar por nombre
	
	@GetMapping("name/{name}")
	public List<Producto> findByName(@PathVariable("name") String name) throws Exception{
		return productoService.findByName(name);
	}
}
