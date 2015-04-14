package main.java.org.pandawarrior.okHttpWrapper;

import org.pandawarrior.okHttpWrapper.ApiCallback;
import org.pandawarrior.okHttpWrapper.NetworkCallApi;

/**
 * Created by jtliew on 4/14/15.
 */
public class MainJ {
    public static void main(String[] args) {
        NetworkCallApi callApi = NetworkCallApi.INSTANCE;
        String url = "http://tableapp.com/debug/testList";
        callApi.getData(url, CustomerListJ.class, new ApiCallback() {
            @Override
            public <T> void onSuccess(T valueType) {
                CustomerListJ customerListJ = (CustomerListJ) valueType;
                System.out.println(customerListJ.toString());
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
