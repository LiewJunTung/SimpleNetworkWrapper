package org.pandawarrior.okHttpWrapper;

import java.util.List;

/**
 * Created by jtliew on 4/15/15.
 */
public class Weather {
    private List<LocalWeather> weather;

    public List<LocalWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<LocalWeather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather=" + weather +
                '}';
    }
}
