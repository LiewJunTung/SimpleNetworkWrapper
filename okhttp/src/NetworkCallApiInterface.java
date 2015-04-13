import java.io.IOException;

/**
 * Created by jtliew on 4/13/15.
 */
public interface NetworkCallApiInterface {
    public <T> void getData(String url, final Class<T> valueType, final ApiCallback callback) throws IOException;
    <T> void postData(String url, T postData, Class<T> responseClass, ApiCallback callback) throws IOException;
}
