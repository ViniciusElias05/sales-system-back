package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.OrderItemDTO;
import com.viniciuselias.projetotcc.model.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<OrderItemDTO> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public OrderItemDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderItemDTO insert(@RequestBody OrderItemDTO orderItemDTO) {
        return service.insert(orderItemDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public OrderItemDTO update(@PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        return service.update(id, orderItemDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
