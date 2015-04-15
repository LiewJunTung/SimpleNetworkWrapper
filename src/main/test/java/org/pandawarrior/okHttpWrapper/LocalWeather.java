package java.org.pandawarrior.okHttpWrapper;

/**
 * Created by jtliew on 4/16/15.
 */
public class LocalWeather {

    private int id;
    private String main;
    private String description;
    private String icon;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getMain() {
        return main;
    }

    void setMain(String main) {
        this.main = main;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getIcon() {
        return icon;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "LocalWeather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
