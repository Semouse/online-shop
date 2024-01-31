package com.github.semouse.storage;

import com.github.semouse.entities.User;
import java.util.List;

public interface UserStorageService {

    void saveUser(User user);

    List<User> loadUsers();
}
