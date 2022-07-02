package com.example.rbenitec.springbootapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rbenitec.springbootapp.entities.Categoria;
import com.example.rbenitec.springbootapp.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> listar() throws Exception {
		return categoriaRepository.listar();
	}

}
