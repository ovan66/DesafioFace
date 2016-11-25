package com.desafiolatam.desafioface.network.fcm;

import android.print.PageRange;

import com.desafiolatam.desafioface.data.UserInfoData;
import com.desafiolatam.desafioface.network.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;

/**
 * Created by santo_000 on 25-11-2016.
 */

public class fcmInterceptor {

    public PostToken getInterceptor() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("authtoken", new UserInfoData().authToken())
                        .header("Source", "mobile")
                        .build();

                Response response = chain.proceed(request);

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        PostToken service = interceptor.create(PostToken.class);
        return service;
    }
}
