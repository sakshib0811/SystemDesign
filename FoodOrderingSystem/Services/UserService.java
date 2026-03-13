package Services;

import Exception.InvalidOperationException;
import Models.User;
import Repository.UserRepository;
import Util.IdGenerator;

public class UserService {
    UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String register(String name, String email, String phone) {
        if (name == null || name.isEmpty())
            throw new InvalidOperationException("User not found");
        String id = IdGenerator.generateId();
        repo.save(new User(id, name, email, phone));
        return id;
    }

}
