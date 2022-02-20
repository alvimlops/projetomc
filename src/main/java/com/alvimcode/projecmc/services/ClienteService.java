package com.alvimcode.projecmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvimcode.projecmc.domain.Cliente;
import com.alvimcode.projecmc.repositories.ClienteRepository;
import com.alvimcode.projecmc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	//Estancia automaticamente pelo Spring, usando esse anotation
	@Autowired
	private ClienteRepository repo;
	
	//Operação capaz de busca uma categoria por codigo.
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Cliente.class.getName());
		}	
			
			
		return obj.orElse(null);
	}

}
