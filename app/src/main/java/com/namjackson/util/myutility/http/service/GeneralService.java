package com.namjackson.util.myutility.http.service;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by namjai on 2017-07-13.
 */

public interface GeneralService {

    /**
     * 로그인
     */
    /*@POST("login.do")
    Call<UserBean> login(@Body UserBean bean);*/

    @POST("selectList.do")
    Observable<List<String>> selectList(@Query("search") String search);

    @POST("login.do")
    Observable<String> login(@Body Map<String,String> map);

}
