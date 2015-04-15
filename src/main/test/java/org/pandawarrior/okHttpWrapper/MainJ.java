package java.org.pandawarrior.okHttpWrapper;

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


        callApi.getData(url, Weather.class, new ApiCallback() {
            @Override
            public <T> void onSuccess(T valueType) {
                Weather weather = (Weather) valueType;
                System.out.println(weather.getWeather().get(0).getDescription());
                System.exit(0);
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }

    static class BB {
        private int x;
        private List<Name> name;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public List<Name> getName() {
            return name;
        }

        public void setName(List<Name> n) {
            name = n;
        }
    }

    static class Name {
        protected String first, last;

        public String getFirst() {
            return first;
        }

        public void setFirst(String n) {
            first = n;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String n) {
            last = n;
        }
    }
}
