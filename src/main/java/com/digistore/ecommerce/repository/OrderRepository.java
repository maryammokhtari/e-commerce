package com.digistore.ecommerce.repository;

import com.digistore.ecommerce.repository.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByUserInfoId(Long userInfoId);
}
