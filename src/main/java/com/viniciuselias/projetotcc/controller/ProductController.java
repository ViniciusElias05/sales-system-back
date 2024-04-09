package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import com.viniciuselias.projetotcc.model.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @GetMapping(value="/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductDTO insert(@RequestBody ProductDTO productDTO) {
        return service.insert(productDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return service.update(id, productDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
