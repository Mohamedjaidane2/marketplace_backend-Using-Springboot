package com.example.marketplace.repository;

import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.DiscountRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiscountRequestRepository extends JpaRepository<DiscountRequest,Integer> {
    boolean existsByAccountAndAdvertisement(Account account, Advertisement advertisement);
    List<DiscountRequest> findByAccountAccountId(Integer accountId);

    List<DiscountRequest> findByAdvertisementAccountAccountId(Integer advertisementAccountId);
    List<DiscountRequest> findByAdvertisementId(Integer advertisementId);
}
