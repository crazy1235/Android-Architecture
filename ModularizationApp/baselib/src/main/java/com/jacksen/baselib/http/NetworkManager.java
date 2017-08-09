package com.jacksen.baselib.http;

import com.jacksen.baselib.base.BaseContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jacksen on 2017/7/26.
 */

public class NetworkManager {

    private static NetworkManager networkManager = null;

    private Retrofit retrofit = null;

    private final int DEFAULT_TIME_OUT_CONNECT = 5;

    private final int DEFAULT_TIME_OUT = 30;

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
        this.retrofit = new Retrofit.Builder()
                .client(initOkHttpClient())
                .baseUrl(BaseContract.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
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

        // TODO 添加统一头文件
        /*builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("", "").build();
                return chain.proceed(request);
            }
        });*/

        builder.connectTimeout(DEFAULT_TIME_OUT_CONNECT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        return builder.build();
    }


    /**
     * 获取对应的Service
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }


    public <T> Observable<T> observe(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
