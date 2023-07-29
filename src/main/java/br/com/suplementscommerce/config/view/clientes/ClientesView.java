package br.com.suplementscommerce.config.view.clientes;

import br.com.suplementscommerce.repository.ClienteRepository;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ClientesView {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping
    public ModelAndView clientes(){
        ModelAndView andView = new ModelAndView("/clientes");
        Iterable<Cliente> clientesIt = clienteRepository.findAll();
        andView.addObject("clientes", clientesIt);
        return andView;
    }
}
