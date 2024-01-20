package service;

import repository.UserRepository;

public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void addUser(String name,String gender,int age){
        userRepository.addUser(name,age,gender);
    }
}
