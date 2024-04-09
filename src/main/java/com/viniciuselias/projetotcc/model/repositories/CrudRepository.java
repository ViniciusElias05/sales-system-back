package com.viniciuselias.projetotcc.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T,ID> extends JpaRepository<T, ID> {

    <S extends T> S save(S entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void delete(T entity);
    void deleteById(ID id);

    void deleteAll();

}
