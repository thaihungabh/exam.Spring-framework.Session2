package application;

import javabasedConfiguration.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.IUserService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        IUserService userService = context.getBean("userService",IUserService.class);

        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("Choose : [1- 5] & Another Once To Exit");
            System.out.println("1.Get All User");
            System.out.println("2.Create User");
            System.out.println("3.Edit User");
            System.out.println("4.Find User By ID");
            System.out.println("5.Remove User By ID");
            System.out.println("6.Search By First Name");
            int chon = Integer.parseInt(input.nextLine());
            switch (chon) {
                case 1:
                        userService.getAllUser();
                    break;
                case 2:
                    userService.createUser();
                    break;
                case 3:
                    System.out.print("Enter UserID: ");
                    int userId = Integer.parseInt(input.nextLine());
                    userService.editUser(userId);
                    break;
                case 4:
                    System.out.print("Enter UserID: ");
                    int id = Integer.parseInt(input.nextLine());
                    userService.findUserById(id);
                    break;
                case 5:
                    System.out.print("Enter UserID: ");
                    int iD = Integer.parseInt(input.nextLine());
                    userService.removeUser(iD);
                    break;
                case 6:
                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    userService.searchByName(name);
                    break;
                default:
                    System.out.println("Tạm biệt");
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
