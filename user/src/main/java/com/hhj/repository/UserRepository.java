package com.hhj.repository;

import com.hhj.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRepository {

    public List<User> findAll(int index, int limit);

    public int count();

    public User findById(int id);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteById(int id);
}
