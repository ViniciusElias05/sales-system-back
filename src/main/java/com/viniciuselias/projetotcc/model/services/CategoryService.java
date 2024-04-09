package com.viniciuselias.projetotcc.model.services;

import com.viniciuselias.projetotcc.model.dto.CategoryDTO;
import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.repositories.CategoryRepository;
import com.viniciuselias.projetotcc.model.services.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> findAll() {
        return repository.findAll().stream().map(obj -> new CategoryDTO(obj)).toList();

    }

    public CategoryDTO findByName(String name){
        return repository.findByName(name).map(cat -> new CategoryDTO(cat)).orElseThrow(()-> new ObjectNotFoundException(1L));
    }

    public CategoryDTO findById(Long id) {
        return repository.findById(id).map(cat -> new CategoryDTO(cat))
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category category = repository.save(new Category(categoryDTO));
        return new CategoryDTO(category);
    }
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
       return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(categoryDTO.name());
                    return repository.save(recordFound);
                })
               .map(cat -> new CategoryDTO(cat))
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
