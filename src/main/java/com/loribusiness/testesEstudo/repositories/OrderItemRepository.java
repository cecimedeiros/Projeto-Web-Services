package com.loribusiness.testesEstudo.repositories;

import com.loribusiness.testesEstudo.entities.Order;
import com.loribusiness.testesEstudo.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
