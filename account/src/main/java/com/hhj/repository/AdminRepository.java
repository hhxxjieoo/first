package com.hhj.repository;

import com.hhj.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AdminRepository {

    public Account login(String username, String password);
}
