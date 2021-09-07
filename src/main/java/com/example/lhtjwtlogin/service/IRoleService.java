package com.example.lhtjwtlogin.service;

import com.example.lhtjwtlogin.model.Role;
import com.example.lhtjwtlogin.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
