package com.desafiolatam.desafioface.network.sessions;

import com.desafiolatam.desafioface.network.constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by santo_000 on 18-11-2016.
 */

public class SessionInterceptor {

    public Session getInterceptor (){
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(constants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Session login = interceptor.create(Session.class);
        return login;
    }
}
