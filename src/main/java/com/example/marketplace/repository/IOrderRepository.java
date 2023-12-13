package com.example.marketplace.repository;

import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
    boolean existsByAccountAndAdvertisement(Account account, Advertisement advertisement);
    @Query("SELECT o FROM Order o " +
            "JOIN o.advertisement a " +
            "JOIN a.account acc " +
            "WHERE acc.accountId = :accountId")
    List<Order> findAllOrdersByAccountId(@Param("accountId") Integer accountId);
}
