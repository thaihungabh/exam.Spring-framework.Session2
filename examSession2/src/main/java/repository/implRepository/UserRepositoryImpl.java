package repository.implRepository;

import pojobeans.User;
import repository.IUserRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private List<User> listUser;
    @PostConstruct
    public void initListUser(){
        listUser = new ArrayList<User>();
    }
    @PreDestroy
    public void cleanListUser(){
        listUser.clear();
    }
    @Override
    public List<User> getAll() {
        return this.listUser;
    }

    @Override
    public User findById(int userId) {
        for(User u : listUser){
            if(u.getUserId() == userId){
                return listUser.get(listUser.indexOf(u));
            }
        }
        return null;
    }

    @Override
    public void insert(User user) {
        listUser.add(user);
    }

    @Override
    public void update(User user) {
        listUser.set(listUser.indexOf(user),user);
    }

    @Override
    public void delete(User user) {
        listUser.remove(listUser.indexOf(user));
    }
}
