package main.java.org.pandawarrior.okHttpWrapper

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * Created by jtliew on 4/14/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("weather")
class Weather {


    @JsonProperty("weather")
    private List<LocalWeather> localWeathers = new ArrayList<>();

    @JsonCreator
    Weather(@JsonProperty("weather") List<LocalWeather> localWeathers) {
        this.localWeathers = localWeathers
    }

    @JsonProperty("weather")
    List<LocalWeather> getLocalWeathers() {
        return localWeathers
    }
    @JsonProperty("weather")
    void setLocalWeathers(List<LocalWeather> localWeathers) {
        this.localWeathers = localWeathers
    }

    public class LocalWeather{
        @JsonProperty("id")
        int id
        @JsonProperty("main")
        String main
        @JsonProperty("description")
        String description
        @JsonProperty("icon")
        String icon

        @JsonProperty("id")
        int getId() {
            return id
        }

        @JsonProperty("id")
        void setId(int id) {
            this.id = id
        }

        @JsonProperty("main")
        String getMain() {
            return main
        }

        @JsonProperty("main")
        void setMain(String main) {
            this.main = main
        }

        @JsonProperty("description")
        String getDescription() {
            return description
        }

        @JsonProperty("description")
        void setDescription(String description) {
            this.description = description
        }

        @JsonProperty("icon")
        String getIcon() {
            return icon
        }

        @JsonProperty("icon")
        void setIcon(String icon) {
            this.icon = icon
        }
    }
}
