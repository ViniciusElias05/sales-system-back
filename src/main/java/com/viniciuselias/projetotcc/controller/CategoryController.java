package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.CategoryDTO;
import com.viniciuselias.projetotcc.model.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<CategoryDTO>findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryDTO findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryDTO insert(@RequestBody CategoryDTO categoryDTO) {
        return service.insert(categoryDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        return service.update(id, categoryDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
