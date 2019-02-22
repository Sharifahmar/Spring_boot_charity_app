package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.akhtar.entity.JwtRefreshTokenEntity;

@Repository
public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshTokenEntity, String> {

}
