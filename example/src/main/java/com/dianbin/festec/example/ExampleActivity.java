package com.dianbin.festec.example;

import com.dianbin.latte.activitys.ProxyActivity;
import com.dianbin.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }


}
