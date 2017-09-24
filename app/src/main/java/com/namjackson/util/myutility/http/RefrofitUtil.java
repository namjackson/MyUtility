package com.namjackson.util.myutility.http;

import com.namjackson.util.myutility.http.service.GeneralService;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by namjai on 2017-07-13.
 */

public class RefrofitUtil {

    private static RefrofitUtil refrofitUtil;

    private static GeneralService generalService;

    public static RefrofitUtil getInstance() {
        if (refrofitUtil == null) {
            synchronized (RefrofitUtil.class) {
                if (refrofitUtil == null) {
                    refrofitUtil = new RefrofitUtil();
                }
            }
        }
        return refrofitUtil;
    }

    private RefrofitUtil() {
        Retrofit retrofit = RetrofitCreator.createRetrofit();
        generalService = retrofit.create(GeneralService.class);
    }

    /**
     * Retrofit Search url
     */

    public Observable<List<String>> selectList(String search) {
        return generalService.selectList(search);
    }
    public  Observable<String> login(Map<String,String> map) {
        return generalService.login(map);
    }


}
