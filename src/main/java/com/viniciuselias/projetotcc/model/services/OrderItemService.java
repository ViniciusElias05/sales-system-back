package com.viniciuselias.projetotcc.model.services;

import com.viniciuselias.projetotcc.model.dto.OrderItemDTO;
import com.viniciuselias.projetotcc.model.entities.OrderItem;
import com.viniciuselias.projetotcc.model.repositories.OrderItemRepository;
import com.viniciuselias.projetotcc.model.services.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderItemService {
    
    @Autowired
    private OrderItemRepository repository;

    public List<OrderItemDTO> findAll() {
        return repository.findAll().stream().map(OrderItemDTO::new).toList();
    }

    public OrderItemDTO findById(Long id) {
        return repository.findById(id).map(prod -> new OrderItemDTO(prod))
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public OrderItemDTO insert(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = repository.save(new OrderItem(orderItemDTO));
        return new OrderItemDTO(orderItem);
    }
    public OrderItemDTO update(Long id, OrderItemDTO orderItemDTO) {
       return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setQuantity(orderItemDTO.quantity());
                    recordFound.setPrice(orderItemDTO.price());
                    recordFound.setProduct(orderItemDTO.product());
                    recordFound.setOrder(orderItemDTO.order());
                    return repository.save(recordFound);
                })
               .map(prod -> new OrderItemDTO(prod))
               .orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public void delete(Long id) {
        try{
            repository.delete(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id)));
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
