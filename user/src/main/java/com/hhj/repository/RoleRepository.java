package com.hhj.repository;


import com.hhj.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleRepository {

    public Role findById(int id);

    public List<Role> findAllRole();
}
