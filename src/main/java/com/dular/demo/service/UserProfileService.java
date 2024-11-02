package com.dular.demo.service;

import com.dular.demo.DTO.UserProfileDto;
import com.dular.demo.domain.UserProfile;
import com.dular.demo.repository.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maiquelknechtel on 16/07/24.
 */
@Service
public class UserProfileService {
    @Autowired
    private UserProfileDao userProfileDao;

    public UserProfile create(UserProfile userProfile){
        return userProfileDao.save(userProfile);
    }
    public List<UserProfile> findAll(){return (List<UserProfile>) userProfileDao.findAll();}

    public void delete(Integer id) {
        userProfileDao.deleteById(id);
    }

    public UserProfile findByLoginAndPassword(UserProfileDto userProfile){
        return userProfileDao.findByLoginAndPassword(userProfile.getLogin(), userProfile.getPassword());
    }
}
