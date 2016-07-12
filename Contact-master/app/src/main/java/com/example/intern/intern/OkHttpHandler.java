package com.example.intern.intern;

import android.os.AsyncTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sodajune on 6/24/16.
 */
public class OkHttpHandler extends AsyncTask<String, Void, String> {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);

        Request request = builder.build();

        try {

            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
        }

        return null;
    }
}
