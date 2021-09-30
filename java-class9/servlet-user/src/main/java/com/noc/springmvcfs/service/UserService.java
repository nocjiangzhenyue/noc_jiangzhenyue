package com.noc.springmvcfs.service;


import com.noc.springmvcfs.model.User;

public interface UserService {
    String URL = "mongodb://192.168.206.130:27017";

    boolean addUser(User user);
    String getUser(String name, String age);
}
