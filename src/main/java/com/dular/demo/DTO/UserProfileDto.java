package com.dular.demo.DTO;

import com.dular.demo.domain.UserProfile;

/**
 * Created by maiquelknechtel on 13/07/24.
 */
public class UserProfileDto {

    private Integer id;
    private String login;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile toBuild(UserProfileDto userProfileDto){
        UserProfile userProfile = new UserProfile();
        userProfile.setLogin(userProfileDto.getLogin());
        userProfile.setPassword(userProfile.getPassword());
        if(userProfileDto.getId()!=null){
            userProfile.setId(userProfileDto.getId());
        }
        return userProfile;
    }

    public UserProfileDto toDto(UserProfile userProfile){
        UserProfileDto user = new UserProfileDto();
        user.setLogin(userProfile.getLogin());
        user.setPassword(userProfile.getPassword());
        return user;
    }
}
