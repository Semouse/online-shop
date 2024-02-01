package com.github.semouse;

import com.github.semouse.config.ApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();
        context.getMainMenu().init();
    }
}
