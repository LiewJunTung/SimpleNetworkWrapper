package android.tableapp.com.tableappmerchantapp.networkUtility;

/**
 * Created by jtliew on 4/13/15.
 */
public interface ApiCallback {
    <T> void onSuccess(T valueType);
    void onFail(Exception e);
}
