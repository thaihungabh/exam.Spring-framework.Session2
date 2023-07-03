package service.implService;

import pojobeans.User;
import repository.IUserRepository;
import service.IUserService;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements IUserService {
    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getAllUser() {
        List<User> listUser = userRepository.getAll();
        for(User u : listUser){
            System.out.println(u.toString());
        }
    }

    @Override
    public void findUserById(int userId) {
        User user = userRepository.findById(userId);
        if(user != null){
            System.out.println(user.toString());
        }else{
            System.out.println("User Not Exist");
        }
    }

    @Override
    public void createUser() {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("User ID: "+(userRepository.getAll().size()+1));
        user.setUserId(userRepository.getAll().size()+1);
        System.out.print("First Name: ");
        user.setUserFirstName(sc.nextLine());
        System.out.print("Last Name: ");
        user.setUserLastName(sc.nextLine());
        System.out.print("Address: ");
        user.setAddress(sc.nextLine());

        if(userRepository.getAll().contains(user)){
            System.out.println("User Existed");
        }else{
            userRepository.insert(user);
            System.out.println("Create Successfuly!");
        }
    }

    @Override
    public void editUser(int userId) {
        Scanner sc = new Scanner(System.in);
        List<User> listUser = userRepository.getAll();
        for(User u : listUser){
            if(u.getUserId() == userId){
                System.out.println("+--------------------+");
                System.out.println(u.toString());
                System.out.println("Ready To Modify");
                System.out.println("+--------------------+");
                System.out.print("First Name: ");
                u.setUserFirstName(sc.nextLine());
                System.out.print("Last Name: ");
                u.setUserLastName(sc.nextLine());
                System.out.print("Address: ");
                u.setAddress(sc.nextLine());
                userRepository.update(u);
                System.out.println("Edit Successful");
                break;
            }
        }
    }

    @Override
    public void removeUser(int userId) {
        List<User> listUser = userRepository.getAll();
        for(User u : listUser){
            if(u.getUserId() == userId){
                userRepository.delete(u);
                System.out.println("User Deleted");
                break;
            }
        }
    }

    @Override
    public void searchByName(String name) {
        List<User> listUser = userRepository.getAll();
        for(User u : listUser){
            if(u.getUserFirstName().toLowerCase().contains(name.toLowerCase()) ||
                    u.getUserLastName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(u.toString());
            }
        }
    }
}
