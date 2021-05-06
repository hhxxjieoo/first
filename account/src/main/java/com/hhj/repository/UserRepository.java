package com.hhj.repository;

import com.hhj.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository {

    public User login(String username, String password);

}
