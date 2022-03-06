package com.alvimcode.projecmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimcode.projecmc.domain.Pedido;


//Capaz de realizar operações de acesso a dados
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
