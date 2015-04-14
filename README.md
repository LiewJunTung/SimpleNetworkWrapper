# okHttpWrapper
An okHttp wrapper that allows handling of web request and conversion to Java object witout much code.

## Installation
include it into your project to build it or [Get the Jar file](https://github.com/pandawarrior91/okhttp_wrapper/releases)

## Usage 
### Get
1. Instantiate the NetworkCallApi
```java
NetworkCallApi callApi = NetworkCallApi.INSTANCE;
```

2. Create a pojo class for Json to convert into.
```java
//
public class Weather {
    @SerializedName("weather")
    private List<LocalWeather> localWeathers = new ArrayList<>();
    
    //Getters and setters

    public class LocalWeather{
        int id;
        String main;
        String description;
        String icon;

        //Getters and setters
    }
}
```

3. Call the API
```java
String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk";
callApi.getData(url, Weather.class, new ApiCallback() {
    @Override
    public <T> void onSuccess(T valueType) {
        Weather weather = (Weather) valueType;
        // Do things
    }

    @Override
    public void onFail(Exception e) {

    }
});
```
### Get Android
1. Same with Step 1 above
2. Same with Step 2 above
3. 
```java
String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk";
callApi.getData(url, Weather.class, new ApiCallback() {
    @Override
    public <T> void onSuccess(T valueType) {
        Weather weather = (Weather) valueType;
        // Do things
        // In order to manipulate UI items, use this:
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(weather.toString());
            }
        });
        
    }

    @Override
    public void onFail(Exception e) {

    }
});
```

### More to come

