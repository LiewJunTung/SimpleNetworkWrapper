package main.org.pandawarrior.okHttpWrapper;

import org.pandawarrior.okHttpWrapper.ApiCallback;
import org.pandawarrior.okHttpWrapper.NetworkCallApi;

import java.util.List;

/**
 * Created by jtliew on 4/14/15.
 */
public class MainJ {
    public static void main(String[] args) {
        NetworkCallApi callApi = NetworkCallApi.INSTANCE;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk";

        callApi.getData(url, "QUEEE", Weather.class, new ApiCallback<Weather>() {
            @Override
            public void onSuccess(Weather weather) {
                System.out.println(weather.toString());
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }

}
