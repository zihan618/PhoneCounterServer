package com.phonecounter.server.controller;

import com.phonecounter.server.model.User;
import com.phonecounter.server.model.WebResult;
import com.phonecounter.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public WebResult login(@RequestBody User user) {
        WebResult<Integer> webResult = new WebResult<>();
        try {
            Integer res = userService.login(user);
            if (res != null) {
                webResult.setSuccess(true);
                webResult.setData(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            webResult.setSuccess(false);
        }
        return webResult;
    }

    @PostMapping("user")
    public WebResult register(@RequestBody User user) {
        WebResult<Integer> webResult = new WebResult<>();
        try {
            boolean res = userService.register(user);
            if (res) {
                webResult.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            webResult.setSuccess(false);
        }
        return webResult;
    }
}
