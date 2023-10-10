package com.example.backbyteacookie.services;

import com.example.backbyteacookie.DAO.UserDao;
import com.example.backbyteacookie.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    public List<User> findAll() {
        return userDao.findAll();
    }
}
