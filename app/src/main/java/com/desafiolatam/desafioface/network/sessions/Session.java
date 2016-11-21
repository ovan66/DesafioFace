package com.desafiolatam.desafioface.network.sessions;

import com.desafiolatam.desafioface.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by santo_000 on 18-11-2016.
 */

public interface Session {

    @FormUrlEncoded
    @POST("mobile_sessions")
    Call<UserInfo> getLogin(@Field("session[email]") String email,  @Field("session[password]")String password);


}
