package com.dianbin.festec.example;

import android.app.Application;

import com.dianbin.latte.app.Latte;
import com.dianbin.latte.ec.icon.FontEcModel;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by 63206 on 2017/9/4.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Latte.init(this)
                .withIcon(new FontEcModel())
                .withIcon(new FontAwesomeModule())
                .withApiHost("https://www.baidu.com/")
                .configure();
    }
}
