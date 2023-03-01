package com.project.questapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer>  {

	RefreshToken findByUserId(Integer userId);

}
