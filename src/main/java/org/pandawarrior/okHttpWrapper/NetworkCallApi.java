package org.pandawarrior.okHttpWrapper;


import com.fasterxml.jackson.jr.ob.JSON;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

/**
 * Created by jtliew on 4/13/15.
 */
public enum NetworkCallApi implements NetworkCallApiInterface {
    INSTANCE;
    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final String DEFAULT_TAG = "DEFAULT";
    private final OkHttpClient client = new OkHttpClient();

    @Override
    public <T> void getData(String url, String tag, final Class<T> responseClass, final ApiCallback callback) {
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .tag(tag)
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }

    @Override
    public <T> void getData(String url, final Class<T> responseClass, final ApiCallback callback) {
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }


    @Override
    public <T> void postData(String url, String tag, Object postData, Class<T> responseClass, ApiCallback callback) throws IOException {
        String jsonRequest = JSON.std.asString(postData);
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .tag(tag)
                .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }

    @Override
    public <T> void postData(String url, Object postData, Class<T> responseClass, ApiCallback callback) throws IOException {
        String jsonRequest = JSON.std.asString(postData);
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }


    private <T> void doNetworkCall(OkHttpClient client,
                                   Request request,
                                   final Class<T> responseClass,
                                   final ApiCallback callback) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFail(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Reader res = response.body().charStream();
                T result = JSON.std.beanFrom(responseClass, res);
                callback.onSuccess(result);
            }
        });
    }


    public void stopRequest() {
        client.cancel(DEFAULT_TAG);
    }

    public void stopRequest(String tag) {
        client.cancel(tag);
    }
}
