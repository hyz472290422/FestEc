package com.dianbin.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by 63206 on 2017/9/4.
 */

public final class Latte {

    //对外的工具类，都是静态类
    public static Configurator init(Context context) {
        getConfigutatetions().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigutatetions() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigutatetions().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
