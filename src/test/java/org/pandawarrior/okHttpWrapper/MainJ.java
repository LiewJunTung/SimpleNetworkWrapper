package org.pandawarrior.okHttpWrapper;

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
