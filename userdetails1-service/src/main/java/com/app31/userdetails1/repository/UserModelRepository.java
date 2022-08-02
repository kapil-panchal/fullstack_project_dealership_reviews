package com.app31.userdetails1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app31.userdetails1.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, UUID>{

}