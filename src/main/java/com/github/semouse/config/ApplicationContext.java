package com.github.semouse.config;

import com.github.semouse.entities.User;

public class ApplicationContext {
    private static ApplicationContext instance;

    public static ApplicationContext getInstance() {
        if(instance == null){
            instance = new ApplicationContext();
        }
        return instance;
    }
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
