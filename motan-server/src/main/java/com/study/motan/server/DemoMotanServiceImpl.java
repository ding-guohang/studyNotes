package com.study.motan.server;

import com.study.motan.api.DemoMotanService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

@MotanService
public class DemoMotanServiceImpl implements DemoMotanService {

    public String doSth(String input) {
        System.out.println("get input" + input);
        return "output";
    }
}
