package com.example.rbenitec.springbootapp.repository;

import com.example.rbenitec.springbootapp.entities.*;
import java.util.List;

public interface CategoriaRepository {

	public List<Categoria> listar() throws Exception;

}
