package com.namjackson.util.myutility.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by namjai on 2017-07-13.
 */

public class RetrofitCreator {
    final static String SERVER_URL= "http://cobook/MaximoAppDS/";

    final static int CONNECT_TIMEOUT = 30;

    public static Retrofit createRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)                         // http 로깅처리
                //.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS) // 연결 타임아웃 시간 설정
                .build();

        return new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Rxandroid 사용을 위한
                .addConverterFactory(GsonConverterFactory.create())        // JSON 파싱
                .build();
    }
}
