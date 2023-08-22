package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.PedidoRepository;
import br.com.suplementscommerce.repository.entities.Pedido;
import br.com.suplementscommerce.service.exceptions.DataBaseException;
import br.com.suplementscommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById (Long id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Pedido insert(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id){
        try{
            pedidoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Pedido update(Long id, Pedido obj){
        try {
            Pedido entity = pedidoRepository.getReferenceById(id);
            updateData(entity, obj);
            return pedidoRepository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Pedido entity, Pedido obj){
        entity.setCliente(obj.getCliente());
        entity.setStatusPedido(obj.getStatusPedido());
        entity.setMomento(obj.getMomento());
        entity.setPagamento(obj.getPagamento());
    }

}
