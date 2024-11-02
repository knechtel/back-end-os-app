package com.dular.demo.repository;

import com.dular.demo.domain.Client;
import com.dular.demo.domain.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maiquelknechtel on 13/07/24.
 */
@Repository
public interface UserProfileDao extends CrudRepository<UserProfile, Integer> {

    @Query("select c from UserProfile c where c.login = :login   and c.password = :password")
    UserProfile findByLoginAndPassword(@Param("login")String login,@Param("password")String password);
}
