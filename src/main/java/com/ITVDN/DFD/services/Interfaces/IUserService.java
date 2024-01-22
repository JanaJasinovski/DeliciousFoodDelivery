package com.ITVDN.DFD.services.Interfaces;

import com.ITVDN.DFD.entities.User;

import java.util.List;

public interface IUserService {
    boolean userExists(String username);
    void createUser(User user);
    User get(Long id);
    List<User> getList();
}
