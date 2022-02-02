package com.alvimcode.projecmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alvimcode.projecmc.domain.Categoria;
import com.alvimcode.projecmc.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjecmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjecmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritotio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
