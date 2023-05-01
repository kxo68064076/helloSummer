package com.capricorn.summer;

import com.alibaba.druid.filter.config.ConfigTools;

public class Druid_ConfigTools {
    public static void main(String[] args) throws Exception {
        String password = "capricorn";
        ConfigTools.main(new String[]{password});

    }
}
