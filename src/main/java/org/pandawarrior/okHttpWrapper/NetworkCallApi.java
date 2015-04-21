package org.pandawarrior.okHttpWrapper;


import com.fasterxml.jackson.jr.ob.JSON;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by jtliew on 4/13/15.
 */
public enum NetworkCallApi {
    INSTANCE;
    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final String DEFAULT_TAG = "DEFAULT";
    private final OkHttpClient client = new OkHttpClient();


    public <T> void getData(String url, String tag, final Class<T> responseClass, final ApiCallback<T> callback) {
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .tag(tag)
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }

    public <T> void getData(String url, final Class<T> responseClass, final ApiCallback<T> callback) {
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }


    public <T> void postData(String url, String tag, Object postBean, Class<T> responseClass, ApiCallback<T> callback) {
        String jsonRequest = null;
        try {
            jsonRequest = JSON.std.asString(postBean);
            Request request = new Request.Builder()
                    .url(url)
                    .tag(DEFAULT_TAG)
                    .tag(tag)
                    .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                    .build();
            doNetworkCall(client, request, responseClass, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> void postData(String url, Object postBean, Class<T> responseClass, ApiCallback<T> callback) {
        String jsonRequest = null;
        try {
            jsonRequest = JSON.std.asString(postBean);
            Request request = new Request.Builder()
                    .url(url)
                    .tag(DEFAULT_TAG)
                    .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                    .build();
            doNetworkCall(client, request, responseClass, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            public void onResponse(Response response) {
                Reader res = null;
                try {
                    res = response.body().charStream();
                    T result = JSON.std.beanFrom(responseClass, res);
                    callback.onSuccess(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void stopRequest() {
        client.cancel(DEFAULT_TAG);
        System.out.println("Stopping request.");
    }

    public void stopRequest(String tag) {
        client.cancel(tag);
        System.out.println("Stopping " + tag + "request.");
    }
}
