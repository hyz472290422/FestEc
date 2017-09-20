package com.dianbin.latte.net.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 63206 on 2017/9/20.
 */

public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;


    public RequestCallbacks(IRequest mIRuquest, ISuccess mISuccess, IError mIError, IFailure mIFailure) {
        this.REQUEST = mIRuquest;
        this.SUCCESS = mISuccess;
        this.ERROR = mIError;
        this.FAILURE = mIFailure;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            } else {
                if (ERROR != null) {
                    ERROR.onError(response.code(), response.message());
                }
            }

        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
    }
}
