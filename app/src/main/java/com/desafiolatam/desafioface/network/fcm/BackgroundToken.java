package com.desafiolatam.desafioface.network.fcm;

        import android.os.AsyncTask;
        import android.speech.tts.Voice;
        import android.util.Log;

        import java.io.IOException;

        import retrofit2.Call;
        import retrofit2.Response;

/**
 * Created by santo_000 on 25-11-2016.
 */

public class BackgroundToken extends AsyncTask<String, Void, Integer> {
    @Override
    protected Integer doInBackground(String... string) {

        PostToken postToken = new fcmInterceptor().getInterceptor();
        Call<String> call = postToken.postToken(string[0]);

        try {
            Response<String> response = call.execute();
            Log.d("POST_TOKEN_RESPONSE", String.valueOf(response.code()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
