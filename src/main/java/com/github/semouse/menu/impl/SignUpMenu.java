package com.github.semouse.menu.impl;

import com.github.semouse.config.ApplicationContext;
import com.github.semouse.entities.User;
import java.util.Scanner;

public class SignUpMenu implements Menu {

    private final ApplicationContext context = ApplicationContext.getInstance();

    @Override
    public void init() {
        System.out.println("SIGN UP");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter last name: ");
        String lastName = input.nextLine();

        System.out.println("Enter password: ");
        String password = input.nextLine();

        System.out.println("Enter email: ");
        String email = input.nextLine();

        context.getStorageService().loadUsers();
        User user = new User(firstName, lastName, password, email);
        context.getStorageService().saveUser(user);

        System.out.println("New user is created");
        context.setUser(user);
    }
}
