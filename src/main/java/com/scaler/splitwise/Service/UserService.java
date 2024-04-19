package com.scaler.splitwise.Service;

import com.scaler.splitwise.Model.User;
import com.scaler.splitwise.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public User createUser(User user)
    {
        return userRepository.save(user);
    }
}
