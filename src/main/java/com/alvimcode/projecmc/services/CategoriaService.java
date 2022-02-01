package com.alvimcode.projecmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvimcode.projecmc.domain.Categoria;
import com.alvimcode.projecmc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	//Estancia automaticamente pelo Spring, usando esse anotation
	@Autowired
	private CategoriaRepository repo;
	
	//Operação capaz de busca uma categoria por codigo.
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
