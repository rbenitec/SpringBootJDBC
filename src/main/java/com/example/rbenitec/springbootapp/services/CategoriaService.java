package com.example.rbenitec.springbootapp.services;

import java.util.List;

import com.example.rbenitec.springbootapp.entities.Categoria;

public interface CategoriaService {
	public List<Categoria> listar() throws Exception;
}
