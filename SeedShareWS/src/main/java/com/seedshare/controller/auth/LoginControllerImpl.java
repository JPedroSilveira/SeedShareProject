package com.seedshare.controller.auth;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seedshare.helpers.IsHelper;
import com.seedshare.service.user.UserServiceImpl;

/**
 * Controller class for Login
 * 
 * @author joao.silva
 */
@RestController
@RequestMapping("/auth")
public class LoginControllerImpl extends IsHelper implements LoginController{

    @Autowired
    UserServiceImpl userService;
    
    @Override
    @GetMapping("/login")
    public com.seedshare.entity.User getUserDetails() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(userService::findOneByEmail)
                .orElse(null);
    }
}       