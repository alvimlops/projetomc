package com.alvimcode.projecmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimcode.projecmc.domain.Cidade;


//Capaz de realizar operações de acesso a dados
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
