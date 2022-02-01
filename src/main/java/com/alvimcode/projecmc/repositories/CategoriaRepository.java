package com.alvimcode.projecmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimcode.projecmc.domain.Categoria;


//Capaz de realizar operações de acesso a dados
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
