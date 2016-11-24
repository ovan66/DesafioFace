package com.desafiolatam.desafioface.views.login;

import com.desafiolatam.desafioface.network.sessions.Session;

/**
 * Created by santo_000 on 22-11-2016.
 */

public interface LoginCallback {

    void success();
    void fail(String error);
    void invalidEmail(String error);
    void invalidPassword(String error);

}
