package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomm.akhtar.entity.UserImageEntity;

/** A JPA repository used to perform crud operations on file meta data records in database*/
public interface ImageUploadRepository extends CrudRepository<UserImageEntity, Long> {
}