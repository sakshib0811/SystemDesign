package Repository;

import java.util.*;

import Models.User;

public class UserRepository {
    private static UserRepository instance = null;
    private Map<String, User> users = new HashMap<>();

    public static UserRepository getInstance() {
        if (instance != null)
            return instance;
        instance = new UserRepository();
        return instance;
    }

    // save method helps to register new users
    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    public User findById(String id) {
        return users.get(id);
    }

}
