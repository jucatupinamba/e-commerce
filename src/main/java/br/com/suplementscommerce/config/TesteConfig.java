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

import java.util.Arrays;
@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private Categoria categoria;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private Cliente cliente;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private Produto produto;
    @Autowired
    private ProdutoRepository produtoRepository;
    private SubCategoria subCategoria;

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
    }
}
