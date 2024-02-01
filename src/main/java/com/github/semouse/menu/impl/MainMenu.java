package com.github.semouse.menu.impl;

import com.github.semouse.config.ApplicationContext;
import java.util.Scanner;

public class MainMenu implements Menu {

    private final ApplicationContext context = ApplicationContext.getInstance();

    private static final String MAIN_MENU =
        "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator()
            + "%s" + System.lineSeparator()
            + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator()
            + "5. Settings" + System.lineSeparator()
            + "6. Customer List";

    private static final String MAIN_MENU_LOGGED_IN = String.format(MAIN_MENU, "2. Sign Out");
    private static final String MAIN_MENU_LOGGED_OUT = String.format(MAIN_MENU, "2. Sign In");

    @Override
    public void init() {
        while (true) {
            printMenu();

            Scanner input = new Scanner(System.in);
            System.out.println("User input: ");
            String command = input.next();

            if ("exit".equalsIgnoreCase(command)) {
                break;
            } else {
                switch (command) {
                    case "1" -> context.getSignUpMenu().init();
                    case "2" -> {
                        if (context.getUser() == null) {
                            System.out.println("Sign in stub");
                        } else {
                            System.out.println("Sign out stub");
                        }
                    }
                    case "3" -> System.out.println("Product catalog stub");
                    case "4" -> System.out.println("My orders stub");
                    case "5" -> System.out.println("Setting stub");
                    case "6" -> System.out.println("Customer list stub");
                    default -> System.out.println(
                        "Only 1, 2, 3, 4, 5, 6 commands is allowed. Try one more time.");
                }
            }
        }
    }

    private void printMenu() {
        if (context.getUser() == null) {
            System.out.println(MAIN_MENU_LOGGED_OUT);
        } else {
            System.out.println(MAIN_MENU_LOGGED_IN);
        }
    }
}
