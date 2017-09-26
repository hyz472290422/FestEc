package com.dianbin.latte.net.download;

import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.AsyncTask;

import com.dianbin.latte.app.Latte;
import com.dianbin.latte.net.callback.IError;
import com.dianbin.latte.net.callback.IFailure;
import com.dianbin.latte.net.callback.IRequest;
import com.dianbin.latte.net.callback.ISuccess;
import com.dianbin.latte.utils.file.FileUtil;

import java.io.File;
import java.io.InputStream;
import java.io.PipedReader;

import okhttp3.ResponseBody;

/**
 * Created by hyz on 2017/9/26.
 */

public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private final IRequest mRequest;
    private final ISuccess mISuccess;
    private final IError mIError;
    private final IFailure mIFailure;

    public SaveFileTask(IRequest request, ISuccess iSuccess, IError iError, IFailure iFailure) {
        this.mRequest = request;
        this.mISuccess = iSuccess;
        this.mIError = iError;
        this.mIFailure = iFailure;
    }

    @Override
    protected File doInBackground(Object... params) {

        String downloadDir = (String) params[0];
        String extension = (String) params[1];

        final ResponseBody body = (ResponseBody) params[2];
        final String name = (String) params[3];
        final InputStream is = body.byteStream();//输入流

        if (downloadDir == null || downloadDir.equals("")) {
            downloadDir = "down_load";
        }
        if (extension == null || extension.equals("")) {
            extension = "";
        }

        if (name == null) {
            return FileUtil.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(is, downloadDir, name);
        }
    }

    /**
     * 执行完异步后，回主线程的操作
     *
     * @param file
     */
    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (mISuccess != null) {
            mISuccess.onSuccess(file.getPath());
        }
        if (mRequest != null) {
            mRequest.onRequestEnd();
        }
        autoInstallApk(file);

    }

    private void autoInstallApk(File file) {
        if (FileUtil.getExtension(file.getPath()).equals("apk")) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
