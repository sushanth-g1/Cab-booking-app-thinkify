package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void addUser(String name, String gender, int age, int[] userSource, int[] userDestination){
        userRepository.users.add(new User(name,gender,age,userSource,userDestination));
    }
}
