package com.dianbin.latte.net;

import com.dianbin.latte.net.callback.IError;
import com.dianbin.latte.net.callback.IFailure;
import com.dianbin.latte.net.callback.IRequest;
import com.dianbin.latte.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 63206 on 2017/9/19.
 */

public class RestClientBuilder {

    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRuquest;
    private ISuccess mISuccess;
    private IError mIError;
    private IFailure mIFailure;
    private RequestBody mBody;

    public RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, String value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRuquest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }


    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRuquest, mISuccess, mIError, mIFailure, mBody);
    }
}
