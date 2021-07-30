package com.example.appointme.User;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> userMap; //key: username

    public UserController() {
        userMap = new HashMap<>();
        User admin = new User("admin", "123", "a@gmail.com", false);
        userMap.put("admin", admin);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
