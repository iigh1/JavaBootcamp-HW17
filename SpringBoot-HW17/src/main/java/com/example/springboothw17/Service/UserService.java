package com.example.springboothw17.Service;

import com.example.springboothw17.Model.User;
import com.example.springboothw17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public List<User> getAllUser() {
        return userRepository.findAll();

    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {

        User oldUser = userRepository.getById(id);

        if (oldUser == null) {
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id) {
        User oldUser = userRepository.getById(id);

        if (oldUser == null) {
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }
}
