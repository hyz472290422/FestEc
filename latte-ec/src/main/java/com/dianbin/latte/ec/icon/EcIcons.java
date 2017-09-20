package com.dianbin.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by 63206 on 2017/9/5.
 */

public enum EcIcons implements Icon {

    icon_ali_pay('\ue606'),
    icon_scan('\ue604');


    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
