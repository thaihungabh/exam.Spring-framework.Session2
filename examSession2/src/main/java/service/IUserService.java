package service;

import pojobeans.User;

public interface IUserService {
    void getAllUser();
    void findUserById(int userId);
    void createUser();
    void editUser(int userId);
    void removeUser(int userId);
    void searchByName(String name);
}
