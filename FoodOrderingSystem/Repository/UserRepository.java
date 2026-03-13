package Repository;

import java.util.*;

import Models.User;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    // save method helps to register new users
    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    public User findById(String id) {
        return users.get(id);
    }

}
