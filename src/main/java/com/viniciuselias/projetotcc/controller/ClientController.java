package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.ClientDTO;
import com.viniciuselias.projetotcc.model.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ClientDTO>findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClientDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value="/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClientDTO findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClientDTO insert(@RequestBody ClientDTO clientDTO) {
        return service.insert(clientDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return service.update(id, clientDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
