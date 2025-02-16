package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public interface UserService {
    User wxLogin(UserLoginDTO userLoginDTO) throws IOException, LoginException;
}
