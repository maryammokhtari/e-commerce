package com.digistore.ecommerce.repository;

import com.digistore.ecommerce.repository.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {
}
