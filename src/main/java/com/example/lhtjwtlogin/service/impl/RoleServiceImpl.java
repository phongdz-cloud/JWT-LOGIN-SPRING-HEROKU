package com.example.lhtjwtlogin.service.impl;

import com.example.lhtjwtlogin.model.Role;
import com.example.lhtjwtlogin.model.RoleName;
import com.example.lhtjwtlogin.repository.IRoleRepository;
import com.example.lhtjwtlogin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
