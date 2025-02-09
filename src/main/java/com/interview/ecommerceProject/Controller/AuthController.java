package com.interview.ecommerceProject.Controller;

import com.interview.ecommerceProject.Model.User;
import com.interview.ecommerceProject.Service.UserService;
import com.interview.ecommerceProject.VO.AuthRequest;
import com.interview.ecommerceProject.VO.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return userService.login(request);
    }
}
