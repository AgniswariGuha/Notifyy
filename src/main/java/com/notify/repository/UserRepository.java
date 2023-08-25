package com.notify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notify.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Long>{
	
	public UserDtls findByEmail(String em);
	
	boolean existsByEmail(String email);



}
