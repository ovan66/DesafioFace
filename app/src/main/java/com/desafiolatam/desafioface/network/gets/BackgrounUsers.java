package com.desafiolatam.desafioface.network.gets;

import android.os.AsyncTask;
import android.provider.SyncStateContract;

import com.desafiolatam.desafioface.data.UserData;
import com.desafiolatam.desafioface.models.User;
import com.desafiolatam.desafioface.network.Constants;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by santo_000 on 23-11-2016.
 */

public class BackgrounUsers extends AsyncTask<Void, Void, Integer >{

    private Map<String, String> map;

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public int getUsers(){
        int code = Constants.NOTHING_HAPPENED;
        Users users = UsersInterceptor.getInstance().interceptors();
        Call<User[]> call = users.getUsers(map);
        try{
            Response<User[]> response= call.execute();
            if (response.isSuccessful() && Constants.SUCCESSFUL_RESPONSE == response.code()){
                User[] userArray = response.body();
                if (userArray != null && userArray.length > 0){
                    code = Constants.SUCCESSFUL_RESPONSE;
                    new UserData().handle(userArray);

                }else{
                    code = Constants.EMPTY_RESPONSE;
                }
            }else{
                code = response.code();
            }
        }catch (IOException e){
            e.printStackTrace();
            code = Constants.JAVA_EXCEPTION;
        }
        return code;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return null;
    }
}
