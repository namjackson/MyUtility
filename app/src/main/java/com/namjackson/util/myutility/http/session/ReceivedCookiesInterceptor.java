package com.namjackson.util.myutility.http.session;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by VisionIC on 2018-02-01.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    private SharedPreferencesBase mSps;

    public ReceivedCookiesInterceptor(Context context) {
        mSps = SharedPreferencesBase.getInstanceOf(context);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            // Preference에 cookies를 넣어주는 작업을 수행
            mSps.putHashSet(SharedPreferencesBase.KEY_COOKIE, cookies);
        }

        return originalResponse;
    }
}
