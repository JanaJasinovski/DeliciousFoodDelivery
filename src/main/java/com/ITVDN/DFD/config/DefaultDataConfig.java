package com.ITVDN.DFD.config;

import com.ITVDN.DFD.entities.Role;
import com.ITVDN.DFD.entities.User;
import com.ITVDN.DFD.services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DefaultDataConfig {

  @Autowired
  private IUserService userService;

  private void createDefaultUsers() {
    List.of(
        User.builder().username("john").password("123").build(),
        User.builder().username("jane").password("123").build()
    ).forEach(userService::createUser);

    userService.createUser(
        User.builder().username("admin").password("admin").roles(new HashSet<>(Arrays.asList(Role.ADMIN))).build()
    );

    userService.createUser(
        User.builder().username("moder").password("moder").roles(new HashSet<>(Arrays.asList(Role.MODERATOR))).build()
    );

    userService.createUser(
        User.builder().username("umoderator").password("12345").roles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.MODERATOR))).build()
    );
  }

}
