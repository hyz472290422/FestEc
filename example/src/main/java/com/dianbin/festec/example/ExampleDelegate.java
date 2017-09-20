package com.dianbin.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.dianbin.latte.delegates.LatteDelegate;
import com.dianbin.latte.net.RestClient;
import com.dianbin.latte.net.callback.IError;
import com.dianbin.latte.net.callback.IFailure;
import com.dianbin.latte.net.callback.ISuccess;

/**
 * Created by 63206 on 2017/9/13.
 */

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rooView) {

        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("https://www.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                }).build()
                .get();
    }
}
