package com.desafiolatam.desafioface.network.posts;

import com.desafiolatam.desafioface.models.User;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by santo_000 on 25-11-2016.
 */

public interface Favorites {

    @POST("users/{id}/favorite")
    Call<User> postFavorite(@Path("id") long id);
}
