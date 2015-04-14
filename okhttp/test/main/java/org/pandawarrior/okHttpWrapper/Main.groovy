package main.java.org.pandawarrior.okHttpWrapper

/**
 * Created by jtliew on 4/14/15.
 */
class Main {
    public static void main(String[] args) {
        NetworkCallApi callApi = NetworkCallApi.INSTANCE
        String url = "http://tableapp.com/debug/testList"
        callApi.getData(url, CustomerList.class, new ApiCallback() {
            @Override
            public <T> void onSuccess(T valueType) {
                CustomerList customerList = (CustomerList) valueType
                println(customerList.customers)
            }

            @Override
            void onFail(Exception e) {

            }
        })
    }
}

