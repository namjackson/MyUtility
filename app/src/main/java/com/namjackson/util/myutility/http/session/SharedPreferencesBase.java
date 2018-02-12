package com.namjackson.util.myutility.http.session;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;

/**
 * Created by VisionIC on 2018-02-01.
 */

public class SharedPreferencesBase {
    public static final String KEY_COOKIE = "com.visionic.key.cookie";
    ///////////////////////////////////////////////////////////////////////////////////////////
    private static SharedPreferencesBase dsp = null;

    public static SharedPreferencesBase getInstanceOf(Context c){
        if(dsp==null){
            dsp = new SharedPreferencesBase(c);
        }
        return dsp;
    }
///////////////////////////////////////////////////////////////////////////////////////////
    private Context mContext;

    private SharedPreferences pref;

    public SharedPreferencesBase(Context c) {
        mContext = c;
        final String PREF_NAME = c.getPackageName();
        pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }

    public void putHashSet(String key, HashSet<String> set){
        SharedPreferences.Editor editor = pref.edit();
        editor.putStringSet(key, set);
        editor.commit();
    }

    public HashSet<String> getHashSet(String key, HashSet<String> dftValue){
        try {
            return (HashSet<String>)pref.getStringSet(key, dftValue);
        } catch (Exception e) {
            e.printStackTrace();

            return dftValue;
        }
    }
}
