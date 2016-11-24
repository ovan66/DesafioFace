package com.desafiolatam.desafioface.views.login;

import com.desafiolatam.desafioface.models.UserInfo;
import com.desafiolatam.desafioface.network.sessions.Session;
import com.desafiolatam.desafioface.network.sessions.SessionInterceptor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by santo_000 on 22-11-2016.
 */

public class LogUser {

    private LoginCallback callback;
    private String email, password;

    public LogUser(LoginCallback callback, String email, String password) {
        this.callback = callback;
        this.email = email;
        this.password = password;
    }

    public void validation(){
        if (email.trim().length() > 0
                &&  !email.contains(" ")
                &&  email.contains(".")
                &&  email.contains("@")) {
            if (password.trim().length() > 0 ){
                toServer();
            }else{
                callback.invalidPassword("password invalido");
            }

        }else{
            callback.invalidEmail("Mail invalido");
        }
    }

    private void toServer() {

        Session session = new SessionInterceptor().getInterceptor();
        Call<UserInfo> call = session.getLogin(email,password);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if (response.code()== response.code() && response.isSuccessful()){
                    UserInfo userInfo = response.body();
                    userInfo.create();
                    callback.success();
                } else {
                    callback.fail("Mail o pasword incorrecto");
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                callback.fail("Vuelve a intentarlo");
            }
        });

    }
}
