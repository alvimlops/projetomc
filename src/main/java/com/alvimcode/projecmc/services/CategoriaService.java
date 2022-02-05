package com.alvimcode.projecmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvimcode.projecmc.domain.Categoria;
import com.alvimcode.projecmc.repositories.CategoriaRepository;
import com.alvimcode.projecmc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	//Estancia automaticamente pelo Spring, usando esse anotation
	@Autowired
	private CategoriaRepository repo;
	
	//Operação capaz de busca uma categoria por codigo.
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName());
		}	
			
			
		return obj.orElse(null);
	}

}
