package com.interview.ecommerceProject.Service;

import com.interview.ecommerceProject.Security.JwtService;
import com.interview.ecommerceProject.Model.User;
import com.interview.ecommerceProject.Repo.UserRepo;
import com.interview.ecommerceProject.VO.AuthRequest;
import com.interview.ecommerceProject.VO.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtService jwtService;

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User Registered Successfully";
    }

    public AuthResponse login(AuthRequest authRequest) {
        Optional<User> userOptional = userRepo.findByEmail(authRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                String token = jwtService.generateToken(user);
                return new AuthResponse(token);
            }
        }
        throw new RuntimeException("Invalid Email or Password");
    }

}
