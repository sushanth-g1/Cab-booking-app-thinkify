package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users = new ArrayList<>();
    public void addUser(String name, int age, String gender){
        users.add(new User(name,gender,age));
    }
}
