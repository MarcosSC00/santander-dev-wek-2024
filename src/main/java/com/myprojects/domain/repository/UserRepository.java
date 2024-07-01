package com.myprojects.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprojects.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByAccountNumber(String number);
}
