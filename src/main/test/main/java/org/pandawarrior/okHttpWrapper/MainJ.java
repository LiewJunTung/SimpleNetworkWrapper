package main.java.org.pandawarrior.okHttpWrapper;

import org.pandawarrior.okHttpWrapper.ApiCallback;
import org.pandawarrior.okHttpWrapper.NetworkCallApi;

/**
 * Created by jtliew on 4/14/15.
 */
public class MainJ {
    public static void main(String[] args) {
        NetworkCallApi callApi = NetworkCallApi.INSTANCE;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk";
        callApi.getData(url, WeatherJ.class, new ApiCallback() {
            @Override
            public <T> void onSuccess(T valueType) {
                WeatherJ weatherJ = (WeatherJ) valueType;
                System.out.println(weatherJ.toString());
                System.exit(0);
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
