package com.github.semouse.storage.impl;

import com.github.semouse.entities.User;
import com.github.semouse.storage.UserStorageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileUserStorageServiceTest {

    private final Path storage = Paths.get("src", "test", "resources", "users.csv");
    private final UserStorageService storageService = new FileUserStorageService(storage);

    private final User testUser = new User(1, "Leanid", "Barok", "***", "some@email.com");

    @Test
    void testSavingUser() {
        storageService.saveUser(testUser);

        List<User> users = storageService.loadUsers();
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertEquals(testUser, users.get(0));
    }

    @Test
    void testLoadingUser() {
        storageService.saveUser(testUser);

        List<User> users = storageService.loadUsers();
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertEquals(testUser, users.get(0));
    }

    @AfterEach
    void reset() {
        try {
            Files.deleteIfExists(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}