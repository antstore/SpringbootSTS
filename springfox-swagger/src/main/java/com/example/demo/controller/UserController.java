package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserRequest;
import com.example.demo.service.UserResponseList;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUsers")
    public ResponseEntity<?> getUsersList(@Valid @RequestBody UserRequest request) {

        UserResponse response = new UserResponse(Constant.STATUS_TRUE, Constant.SUCCESS);
        UserResponseList obj = userService.getUserList(request);
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}