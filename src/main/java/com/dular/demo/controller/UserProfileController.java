package com.dular.demo.controller;

import com.dular.demo.DTO.ClientDto;
import com.dular.demo.DTO.UserProfileDto;
import com.dular.demo.domain.Client;
import com.dular.demo.domain.UserProfile;
import com.dular.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maiquelknechtel on 18/07/24.
 */
@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PostMapping(value = "user-create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfile create(@RequestBody UserProfileDto  userProfileDto){
        return userProfileService.create(userProfileDto.toBuild(userProfileDto));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @RequestMapping(value = "user-findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<UserProfile> findAll(){
        return userProfileService.findAll();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @RequestMapping(value = "user-delete", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public void delete(@RequestBody UserProfileDto userProfileDto){
        userProfileService.delete(userProfileDto.getId());
    }
    @RequestMapping(value = "user-find", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public UserProfile findUser(@RequestBody UserProfileDto userProfileDto){
        return  userProfileService.findByLoginAndPassword(userProfileDto);
    }
}
