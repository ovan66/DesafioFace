package com.desafiolatam.desafioface.data;

import com.desafiolatam.desafioface.models.User;

import java.util.List;

/**
 * Created by santo_000 on 23-11-2016.
 */

public class UserData {

    public void handle(User[] users){
        for (User user : users){
            List<User> userList = User.find(User.class, "serverId = ?", String.valueOf(user.getId()));
            if (userList != null || userList.size() == 0 ){
                user.create();
            }
        }
    }
}
