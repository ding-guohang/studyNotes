package com.study.motan.client;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class MotanClientApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new
                String[]{"classpath:motan_demo_client_annotation.xml"});

        ctx = new AnnotationConfigApplicationContext("com.study.motan.client");

        DemoHandler refer = (DemoHandler) ctx.getBean("demoHandler");
        refer.dd();

        System.out.println("Client Finished");
    }

    @Bean
    public AnnotationBean motanAnnotationBean() {
        AnnotationBean motanAnnotationBean = new AnnotationBean();
        motanAnnotationBean.setPackage("com.study.motan.client");
        return motanAnnotationBean;
    }

    @Bean(name = "demoMotan")
    public ProtocolConfigBean demoMotanProtocolConfig() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        //Id无需设置
//        config.setId("demoMotan");
        config.setName("motan");
        config.setDefault(true);
        config.setMaxContentLength(1048576);
        config.setHaStrategy("failover");
        config.setLoadbalance("roundrobin");
        return config;
    }

    @Bean(name = "registry")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
//        config.setRegProtocol("zookeeper");
//        config.setAddress("127.0.0.1:2181");

        config.setRegProtocol("direct");
        config.setAddress("127.0.0.1:8002");
        return config;
    }


    @Bean(name = "motantestClientBasicConfig")
    public BasicRefererConfigBean baseRefererConfig() {
        BasicRefererConfigBean config = new BasicRefererConfigBean();
        config.setProtocol("demoMotan");
        config.setGroup("motan-demo-rpc");
        config.setModule("motan-demo-rpc");
        config.setApplication("myMotanDemo");
        config.setRegistry("registry");
        config.setDefault(true);
        config.setCheck(false);
        config.setAccessLog(true);
        config.setRetries(2);
        config.setThrowException(true);
        return config;
    }
}
