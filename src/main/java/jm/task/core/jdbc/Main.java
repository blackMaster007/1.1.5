package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        List<User> users = new ArrayList<>();
        users.add(new User("Vladimir", "Pupkin", (byte) 48));
        users.add(new User("Andrey", "Kirov", (byte) 13));
        users.add(new User("Alexander", "Shumilov", (byte) 67));
        users.add(new User("Zurab", "Ovshorov", (byte) 20));
        for (User i : users) {
            userService.saveUser(i.getName(), i.getLastName(), i.getAge());
            System.out.printf("User с именем - %s добавлен в базу данных\n", i.getName());
        }
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
