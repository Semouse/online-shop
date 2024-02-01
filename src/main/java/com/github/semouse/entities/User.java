package com.github.semouse.entities;

import java.util.Objects;

public class User {

    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String password, String email) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public User(int id, String firstName, String lastName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName)
            && Objects.equals(lastName, user.lastName) && Objects.equals(password,
            user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, email);
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }
}
