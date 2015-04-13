package org.jt.http_wrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by jtliew on 4/13/15.
 */
public enum NetworkCallApi implements NetworkCallApiInterface {
    INSTANCE;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final String DEFAULT_TAG = "DEFAULT";


    @Override
    public <T> void getData(String url, String tag, final Class<T> responseClass, final ApiCallback callback) {

        Request request = new Request.Builder()
                .url(url)
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
        String jsonRequest = mapper.writeValueAsString(postData);
        Request request = new Request.Builder()
                .url(url)
                .tag(tag)
                .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }

    @Override
    public <T> void postData(String url, Object postData, Class<T> responseClass, ApiCallback callback) throws IOException {
        String jsonRequest = mapper.writeValueAsString(postData);
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
                                   final ApiCallback callback){
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFail(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                System.out.println("onResponseCallback" + res);
                T result = mapper.readValue(res, responseClass);
                callback.onSuccess(result);
            }
        });
    }

    public void stopRequest(){
        client.cancel(DEFAULT_TAG);
    }

    public void stopRequest(String tag){
        client.cancel(tag);
    }
}
