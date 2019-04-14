package com.study.motan.client;

import com.study.motan.api.DemoMotanService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.springframework.stereotype.Service;


@Service
public class DemoHandler {

    @MotanReferer
    private DemoMotanService demoMotanService;

    public void dd() {
        System.out.println(demoMotanService.doSth("do sth for test"));
    }
}
