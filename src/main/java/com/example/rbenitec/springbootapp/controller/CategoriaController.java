package com.example.rbenitec.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rbenitec.springbootapp.entities.Categoria;
import com.example.rbenitec.springbootapp.services.CategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/")
	public List<Categoria> listar() throws Exception{
		return categoriaService.listar();
	}
	
}
