package com.roy.springjwt.repository;

import com.roy.springjwt.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roy on 15-07-2022
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUserName(String userName);
}
