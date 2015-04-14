package main.java.org.pandawarrior.okHttpWrapper

import org.pandawarrior.okHttpWrapper.ApiCallback
import org.pandawarrior.okHttpWrapper.NetworkCallApi

/**
 * Created by jtliew on 4/14/15.
 */
class Main {
    public static void main(String[] args) {
        NetworkCallApi callApi = NetworkCallApi.INSTANCE
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk"
        callApi.getData(url, WeatherJ.class, new ApiCallback() {
            @Override
            public <T> void onSuccess(T valueType) {
                WeatherJ weatherJ = (WeatherJ) valueType
                println(weatherJ.getLocalWeathers().toString())
            }

            @Override
            void onFail(Exception e) {

            }
        })
    }
}

