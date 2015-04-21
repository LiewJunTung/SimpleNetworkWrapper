package org.pandawarrior.okHttpWrapper;

import java.io.IOException;

/**
 * Created by jtliew on 4/13/15.
 */
public interface NetworkCallApiInterface {
    <T> void getData(String url, String tag, Class<T> responseClass, ApiCallback<T> callback);

    <T> void getData(String url, Class<T> responseClass, ApiCallback<T> callback);

    <T> void postData(String url, String tag, Object postData, Class<T> responseClass, ApiCallback<T> callback) throws IOException;

    <T> void postData(String url, Object postData, Class<T> responseClass, ApiCallback<T> callback) throws IOException;
}
