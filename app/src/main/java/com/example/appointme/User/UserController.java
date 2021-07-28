package com.example.appointme.User;

import java.util.Map;

public class UserController {
    private Map<String, User> userMap; //key: username

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
