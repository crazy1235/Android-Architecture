package com.jacksen.baselib.http;

import com.jacksen.baselib.BaseContract;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by jacksen on 2017/7/26.
 */

public class NetworkManager {

    private static NetworkManager networkManager = null;

    private Retrofit retrofit = null;

    /**
     * 初始化对象（单例模式）
     *
     * @return
     */
    public static NetworkManager getInstance() {
        if (null == networkManager) {
            synchronized (NetworkManager.class) {
                if (null == networkManager) {
                    networkManager = new NetworkManager();
                }
            }
        }
        return networkManager;
    }

    private NetworkManager() {
        retrofit = new Retrofit.Builder().client(initOkHttpClient()).baseUrl(BaseContract.BASE_URL).build();
    }


    /**
     * init OkHttpClient
     *
     * @return
     */
    private OkHttpClient initOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().clear();
        builder.addInterceptor(new HttpLoggingInterceptor());
        /*builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("", "").build();
                return chain.proceed(request);
            }
        });*/
        return builder.build();
    }

}
