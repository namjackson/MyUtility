package com.namjackson.util.myutility.http.session;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by VisionIC on 2018-02-01.
 */

public class AddCookiesInterceptor implements Interceptor {
    private SharedPreferencesBase mSps;

    public AddCookiesInterceptor(Context context){
        mSps = SharedPreferencesBase.getInstanceOf(context);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder(); // Preference에서 cookies를 가져오는 작업을 수행
        Set<String> preferences = (HashSet) mSps.getHashSet(SharedPreferencesBase.KEY_COOKIE, new HashSet<String>());

        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
        }

        // Web,Android,iOS 구분을 위해 User-Agent세팅
//        builder.removeHeader("User-Agent").addHeader("User-Agent", "Android");

        return chain.proceed(builder.build());
    }

}
