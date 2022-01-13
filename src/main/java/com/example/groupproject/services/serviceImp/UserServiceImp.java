package com.example.groupproject.services.serviceImp;

import com.example.groupproject.entities.User;
import com.example.groupproject.repositories.UserRepository;
import com.example.groupproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean create(User user) {
        if (user != null) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User get(Integer userId) {
        return userRepository.findUserByUserId(userId).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(User user, Integer userId) {
        try {
            User temp = userRepository.findUserByUserId(userId).get();
            if (temp.equals(user)) {
                System.out.println("You don't have to update");
                return false;
            } else {
                userRepository.save(user);
                return true;
            }
        } catch (Exception E) {
            E.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(User user) {
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception E) {
            E.printStackTrace();
            return false;
        }
    }
}
