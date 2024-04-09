package com.viniciuselias.projetotcc.model.services;

import com.viniciuselias.projetotcc.model.dto.ClientDTO;
import com.viniciuselias.projetotcc.model.entities.Client;
import com.viniciuselias.projetotcc.model.repositories.ClientRepository;
import com.viniciuselias.projetotcc.model.services.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<ClientDTO> findAll() {
        return repository.findAll().stream().map(obj -> new ClientDTO(obj)).toList();
    }

    public ClientDTO findById(Long id) {
        return repository.findById(id).map(obj -> new ClientDTO(obj))
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public ClientDTO findByName(String name){
        return repository.findByName(name).map(obj -> new ClientDTO(obj)).orElseThrow(()-> new ObjectNotFoundException(1L));
    }

    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = repository.save(new Client(clientDTO));
        return new ClientDTO(client);
    }
    public ClientDTO update(Long id, ClientDTO clientDTO) {
       return repository.findById(id)
                .map(client -> {
                    UpdateData(client, clientDTO);
                    return repository.save(client);
                })
               .map(cat -> new ClientDTO(cat))
               .orElseThrow(() -> new ObjectNotFoundException(id));
    }
    
    private void UpdateData(Client client, ClientDTO clientDTO) {
        client.setName(clientDTO.name());
        client.setCnpj(clientDTO.cnpj());
        client.setEmail(clientDTO.email());
        client.setAddress(clientDTO.address());
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
