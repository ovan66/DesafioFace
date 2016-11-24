package com.desafiolatam.desafioface.data;

import com.desafiolatam.desafioface.models.User;
import com.desafiolatam.desafioface.models.UserInfo;

import java.util.List;

import static android.view.View.Z;
import static com.orm.SugarRecord.count;

/**
 * Created by santo_000 on 22-11-2016.
 */

public class UserInfoData {

    public boolean isLoged(){
        long count = UserInfo.count(UserInfo.class);
        if (count > 0){
            return true;
        }else{
            return false;
        }
    }

    public String authToken(){
        return UserInfo.listAll(UserInfo.class).get(0).getAuth_token();
    }
}
