package com.namjackson.util.myutility.http.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by namjai on 2018-02-02.
 * SSL 구현을위해 SSL인증서에는 도메인이 입력되어야하는데
 * 우리는 테스트 인증서 && 도메인이없기 때문에
 * SSL 도메인 검증을 제외하기위한 클래스이다.
 */

public class NullHostNameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}

