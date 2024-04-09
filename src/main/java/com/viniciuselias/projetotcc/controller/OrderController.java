package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.OrderDTO;
import com.viniciuselias.projetotcc.model.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<OrderDTO> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public OrderDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderDTO insert(@RequestBody OrderDTO orderDTO) {
        return service.insert(orderDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return service.update(id, orderDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
