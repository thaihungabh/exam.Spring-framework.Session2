package repository;

import pojobeans.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAll();
    User findById(int userId);
    void insert(User user);
    void update(User user);
    void delete(User user);
}
