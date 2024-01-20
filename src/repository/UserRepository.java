package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> users = new ArrayList<>();
    public List<User> getUsers(){
        return users;
    }
}
