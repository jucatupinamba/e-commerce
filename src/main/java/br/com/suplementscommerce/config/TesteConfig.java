package br.com.suplementscommerce.config;

import br.com.suplementscommerce.repository.CategoriaRepository;
import br.com.suplementscommerce.repository.ClienteRepository;
import br.com.suplementscommerce.repository.ProdutoRepository;
import br.com.suplementscommerce.repository.entities.Categoria;
import br.com.suplementscommerce.repository.entities.Cliente;
import br.com.suplementscommerce.repository.entities.Produto;
import br.com.suplementscommerce.repository.entities.SubCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Acessórios");
        Categoria cat2 = new Categoria(null, "Vestuário");
        Categoria cat3 = new Categoria(null, "Simuladores");
        Categoria cat4 = new Categoria(null, "Eventos");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));


        Cliente clit1 = new Cliente(null, "Juca Tupi", "38", "jucamail@emailteste.com.br", "340.353.654-34", "Rua Roma, 37");
        Cliente clit2 = new Cliente(null, "Sávio do Flamengo", "31", "saviomengo@emailteste.com.br", "267.158.624-39", "Rua Altaier, 65");
        Cliente clit3 = new Cliente(null, "Palhinha da Silva", "22", "palhinha@emailteste.com.br", "442.780.097-45", "Rua Somelier, 69");
        Cliente clit4 = new Cliente(null, "Novaes Moreira", "71", "moreiran@emailteste.com.br", "120.543.098-23", "Rua Ernesto Que Vaga, 29");

        clienteRepository.saveAll(Arrays.asList(clit1, clit2, clit3, clit4));

        Produto prod1 = new Produto(null, "Camiseta de Basquete", "Camisa do Chicago Bulls", "www.chicago.com.br", 106.00);
        Produto prod2 = new Produto(null, "Blusa de Futebol", "Blusão da Gaviões", "www.corinthians.com.br", 300.00);
        Produto prod3 = new Produto(null, "Automoramas Corrida", "Jogo de corrida de Fórmula para xbox", "www.corrida.com.br", 250.00);
        Produto prod4 = new Produto(null, "King of Fighters 96", "Jogo de luta de arcade", "www.kingsof.com.br", 96.50);
        Produto prod5 = new Produto(null, "Óculos Crew", "Oculoes de sol de madeira", "www.osculo.com.br", 125.80);
        Produto prod6 = new Produto(null, "Estética automotiva",  "Evento de limpeza do carro",  "www.carrolimpo.com.br", 129.30);

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6));

        prod1.getCategorias().add(cat1);
        prod2.getCategorias().add(cat2);
        prod3.getCategorias().add(cat3);
        prod4.getCategorias().add(cat4);
        prod5.getCategorias().add(cat3);
        prod6.getCategorias().add(cat2);
    }
}
