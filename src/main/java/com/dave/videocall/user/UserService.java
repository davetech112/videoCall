package com.dave.videocall.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USER_LIST = new ArrayList<>();

    public void register(User user) {
        user.setStatus("online");
        USER_LIST.add(user);
    }

    public User login(User user){
        var userIndex = IntStream.range(0, USER_LIST.size()).filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found"));
        var cUser = USER_LIST.get(userIndex);
        if(!user.getPassword().equals(cUser.getPassword())){
            throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }
}