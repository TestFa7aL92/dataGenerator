package com.example.dataGenerator.service;

import com.example.dataGenerator.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
        User user = new User(1,"ASD", 44, "dzony@gmail.com");
        User user1 = new User(2,"qwe", 22, "qdqd@gmail.com");
        User user2 = new User(3,"zxc", 33, "deede@gmail.com");

        userList.addAll(Arrays.asList(user,user1,user2));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList){
            if(id == user.getId()){
                return Optional.of(user);
            }
        }
        return optional;
    }
}
