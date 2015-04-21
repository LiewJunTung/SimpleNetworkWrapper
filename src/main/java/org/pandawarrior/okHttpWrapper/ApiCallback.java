package org.pandawarrior.okHttpWrapper;

/**
 * Created by jtliew on 4/13/15.
 */
public interface ApiCallback<Param> {
    void onSuccess(Param param);

    void onFail(Exception e);
}
