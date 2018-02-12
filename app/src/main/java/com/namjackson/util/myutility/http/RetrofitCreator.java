package com.namjackson.util.myutility.http;

import android.content.Context;

import com.namjackson.util.myutility.http.session.AddCookiesInterceptor;
import com.namjackson.util.myutility.http.session.ReceivedCookiesInterceptor;
import com.namjackson.util.myutility.http.ssl.NullHostNameVerifier;
import com.namjackson.util.myutility.http.ssl.SSLUtil;

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
    public static OkHttpClient createOkHttp(Context context){
        AddCookiesInterceptor in1 = new AddCookiesInterceptor(context);
        ReceivedCookiesInterceptor in2 = new ReceivedCookiesInterceptor(context);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client =
                new OkHttpClient.Builder()
                        /*SSL 검증*/
////                      getUnsafeOkHttpClient()                                             //안전하지않음 OK 으로 ssl인증서 무시하고 https에 암호화X통신
                        .sslSocketFactory(SSLUtil.getPinnedCertSslSocketFactory(context))   //ssl 통신
                        .hostnameVerifier(new NullHostNameVerifier())                       //ssl 통신시 url 검증 -> NullHostNameVerifier -> 호스트네임은 검증하지않음
                        /*Session관리*/
                        .addNetworkInterceptor(in1)
                        .addInterceptor(in2)
                        /*로깅처리*/
                        .addInterceptor(interceptor)
                        //.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)                //연결 타임아웃 시간 설정
                        .build();
        return client;
    }

    public static Retrofit createRetrofit(Context context) {

        return new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .client(createOkHttp(context))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())                  // Rxandroid 사용을 위한
                .addConverterFactory(GsonConverterFactory.create())                         // JSON 파싱
                .build();
    }

}
