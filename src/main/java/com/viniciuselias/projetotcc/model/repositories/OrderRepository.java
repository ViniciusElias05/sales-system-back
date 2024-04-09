package com.viniciuselias.projetotcc.model.repositories;

import com.viniciuselias.projetotcc.model.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.moment >= :startOfMonth AND o.moment < :startOfNextMonth")
    public List<Order> findByMonthAndYear(
            @Param("startOfMonth") LocalDateTime startOfMonth,
            @Param("startOfNextMonth") LocalDateTime startOfNextMonth
    );
}
