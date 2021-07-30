package com.example.appointme.User;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private static UserController single_instance = null;

    private Map<String, User> userMap; //key: username

    private UserController(){
        userMap = new HashMap<>();
        User admin = new User("admin", "123", "a@gmail.com", false, "1111111111", false);
        userMap.put("admin", admin);
    }

    public static UserController getInstance()
    {
        if (single_instance == null)
            single_instance = new UserController();
        return single_instance;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
