package com.ITVDN.DFD.services;

import com.ITVDN.DFD.entities.Role;
import com.ITVDN.DFD.entities.User;
import com.ITVDN.DFD.repositories.UserRepository;
import com.ITVDN.DFD.services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    @Transactional
    public void createUser(User user) {

        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>(Arrays.asList(Role.USER)));
        }

        userRepository.save(user);
    }

    @Override
    @Transactional
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<User> getList() {
        return userRepository.findAll();
    }
}
