package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.akhtar.entity.JwtRefreshTokenEntity;

@Repository
public interface JwtRefreshTokenRepository extends CrudRepository<JwtRefreshTokenEntity, String> {

}
