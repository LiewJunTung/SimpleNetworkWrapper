package main.java.org.pandawarrior.okHttpWrapper

import com.google.gson.annotations.SerializedName


/**
 * Created by jtliew on 4/14/15.
 */
class Weather {

    @SerializedName("weather")
    private List<LocalWeather> localWeathers;

    List<LocalWeather> getLocalWeathers() {
        return localWeathers
    }

    void setLocalWeathers(List<LocalWeather> localWeathers) {
        this.localWeathers = localWeathers
    }

    public class LocalWeather{
        int id
        String main
        String description
        String icon

        int getId() {
            return id
        }

        void setId(int id) {
            this.id = id
        }

        String getMain() {
            return main
        }

        void setMain(String main) {
            this.main = main
        }

        String getDescription() {
            return description
        }

        void setDescription(String description) {
            this.description = description
        }

        String getIcon() {
            return icon
        }

        void setIcon(String icon) {
            this.icon = icon
        }
    }
}
