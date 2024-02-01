package com.github.semouse.config;

import com.github.semouse.entities.User;
import com.github.semouse.menu.impl.MainMenu;
import com.github.semouse.menu.impl.Menu;
import com.github.semouse.menu.impl.SignUpMenu;
import com.github.semouse.storage.UserStorageService;
import com.github.semouse.storage.impl.FileUserStorageService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ApplicationContext {

    private static ApplicationContext instance;

    private static final Map<String, Menu> menus = Map.of("main", new MainMenu(), "signUp",
        new SignUpMenu());

    public static ApplicationContext getInstance() {
        if (instance == null) {
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

    private final Path storage = Paths.get("src", "main", "resources", "users.csv");
    private final UserStorageService storageService = new FileUserStorageService(storage);


    public UserStorageService getStorageService() {
        return storageService;
    }

    public Menu getMainMenu() {
        return menus.get("main");
    }

    public Menu getSignUpMenu() {
        return menus.get("signUp");
    }
}
