package com.alvimcode.projecmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alvimcode.projecmc.domain.Categoria;
import com.alvimcode.projecmc.domain.Cidade;
import com.alvimcode.projecmc.domain.Cliente;
import com.alvimcode.projecmc.domain.Endereco;
import com.alvimcode.projecmc.domain.Estado;
import com.alvimcode.projecmc.domain.Produto;
import com.alvimcode.projecmc.domain.enums.TipoCliente;
import com.alvimcode.projecmc.repositories.CategoriaRepository;
import com.alvimcode.projecmc.repositories.CidadeRepository;
import com.alvimcode.projecmc.repositories.ClienteRepository;
import com.alvimcode.projecmc.repositories.EnderecoRepository;
import com.alvimcode.projecmc.repositories.EstadoRepository;
import com.alvimcode.projecmc.repositories.ProdutoRepository;


@SpringBootApplication
public class ProjecmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private  CidadeRepository  cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjecmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritotio");
		
		Produto p1 = new Produto(null, "computador" , 2000.00);
		Produto p2 = new Produto(null, "Impressora" , 800.00);
		Produto p3 = new Produto(null, "Mause" , 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais", null);
		Estado est2 = new Estado(null, "São Paulo", null);
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Santos", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		 estadoRepository.saveAll( Arrays.asList(est1, est2));
		 cidadeRepository.saveAll( Arrays.asList(c1, c2, c3));
		 
		 Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "54903874249", TipoCliente.PESSOAFISICA);
		 cli1.getTelefones().addAll(Arrays.asList("66426328", "5674349343"));
		 
		 Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "jardim", "54637438", cli1, c1);
		 Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 800", "centro", "4637438", cli1, c2);
		 
		 cli1.getEndereco().addAll(Arrays.asList(e1, e2));
		 
		 clienteRepository.saveAll(Arrays.asList(cli1));
		 enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
