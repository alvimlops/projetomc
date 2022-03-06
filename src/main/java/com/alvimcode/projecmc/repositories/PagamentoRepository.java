package com.alvimcode.projecmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimcode.projecmc.domain.Pagamento;


//Capaz de realizar operações de acesso a dados
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
