package com.github.semouse.storage.impl;

import com.github.semouse.entities.User;
import com.github.semouse.storage.UserStorageService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class FileUserStorageService implements UserStorageService {

    private final Path storage;

    public FileUserStorageService(Path storage) {
        this.storage = storage;
    }

    @Override
    public void saveUser(User user) {
        try {
            Files.writeString(storage,
                convertUserToCSVFormat(user),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> loadUsers() {
        try (var stream = Files.lines(storage)) {
            return stream.filter(line -> !line.isEmpty()).map(this::convertStringToUser).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private String convertUserToCSVFormat(User user) {
        return user.getId() + "," + user.getFirstName() + "," + user.getLastName() + ","
            + user.getPassword() + "," + user.getEmail() + System.lineSeparator();
    }

    private User convertStringToUser(String line) {
        String[] fields = line.split(",");
        return new User(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3],
            fields[4]);
    }


}
