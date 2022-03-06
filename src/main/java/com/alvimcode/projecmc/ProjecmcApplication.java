package com.alvimcode.projecmc;

import java.text.SimpleDateFormat;
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
import com.alvimcode.projecmc.domain.ItemPedido;
import com.alvimcode.projecmc.domain.Pagamento;
import com.alvimcode.projecmc.domain.PagamentoComBoleto;
import com.alvimcode.projecmc.domain.PagamentoComCartao;
import com.alvimcode.projecmc.domain.Pedido;
import com.alvimcode.projecmc.domain.Produto;
import com.alvimcode.projecmc.domain.enums.EstadoPagamento;
import com.alvimcode.projecmc.domain.enums.TipoCliente;
import com.alvimcode.projecmc.repositories.CategoriaRepository;
import com.alvimcode.projecmc.repositories.CidadeRepository;
import com.alvimcode.projecmc.repositories.ClienteRepository;
import com.alvimcode.projecmc.repositories.EnderecoRepository;
import com.alvimcode.projecmc.repositories.EstadoRepository;
import com.alvimcode.projecmc.repositories.ItemPedidoRepository;
import com.alvimcode.projecmc.repositories.PagamentoRepository;
import com.alvimcode.projecmc.repositories.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		 
		 Pedido ped1 = new Pedido(null, sdf.parse("30/09/2021 10:32"), cli1, e1);
		 Pedido ped2 = new Pedido(null, sdf.parse("10/07/2021 19:56"), cli1, e2);
		 
		 Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		 ped1.setPagamento(pagto1);
		 
		 Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2021 00:00"), null);
		 ped2.setPagamento(pagto2);
		 
		 cli1.getPedido().addAll(Arrays.asList(ped1, ped2));
		 
		 pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		 pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		 
		 ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		 ItemPedido ip2 = new ItemPedido(ped1, p1, 0.00, 2, 80.00);
		 ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		 
		 ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		 ped1.getItens().addAll(Arrays.asList(ip3));
		 
		 p1.getItens().addAll(Arrays.asList(ip1));
		 p2.getItens().addAll(Arrays.asList(ip3));
		 p3.getItens().addAll(Arrays.asList(ip2));
		 
		 itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		 
		 
	}

}
