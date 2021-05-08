package com.laboon.repository;

import com.laboon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    public User findByUsername(String username);

    public List<User> findAllByUsername(String username);

}
