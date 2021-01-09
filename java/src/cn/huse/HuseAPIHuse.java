package cn.huse;

import cn.test.HuseReqAPI;

public class HuseAPIHuse implements HuseReqAPI {
    @Override
    public void reqAPI() {
        System.out.println(System.currentTimeMillis() * 1.0 / 1000 / 60 / 60 / 24 / 365 + " year");
        System.out.println("house  req API...");
    }
}
