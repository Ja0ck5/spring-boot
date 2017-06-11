package com.ja0ck5.provider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ja0ck5.provider.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	

}
