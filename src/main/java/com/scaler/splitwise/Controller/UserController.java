package com.scaler.splitwise.Controller;

import com.scaler.splitwise.Dtos.CreateUserRequest;
import com.scaler.splitwise.Model.User;
import com.scaler.splitwise.Service.UserService;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    private UserService userService;

    public User createUser(CreateUserRequest createUserRequest)
    {
        User user  = createUserRequest.toUser();
        return userService.createUser(user);
    }
}
