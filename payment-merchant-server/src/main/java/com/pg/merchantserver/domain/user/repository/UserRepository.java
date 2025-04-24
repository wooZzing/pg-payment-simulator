package com.pg.merchantserver.domain.user.repository;

import com.pg.merchantserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}