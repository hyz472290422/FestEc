package com.dianbin.latte.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.dianbin.latte.R;
import com.dianbin.latte.app.Latte;
import com.dianbin.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by 63206 on 2017/9/7.
 */

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }
    private void initContainer(@Nullable Bundle savedInstanceState){
        ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if(savedInstanceState == null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭退出
    }
}
