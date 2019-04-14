package com.study.motan.server;

import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@Configuration
public class MotanServerApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new
                String[]{"classpath*:motan_demo_server_annotation.xml"});
        System.out.println("Motan Server Started");

        System.in.read();
    }

    @Bean(name = "demoMotanProtocol")
    public ProtocolConfigBean protocolConfig1() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        config.setDefault(true);
        config.setName("motan");
        config.setMaxContentLength(1048576);
        return config;
    }

    @Bean(name = "demoMotanRegistryConfig")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
//        config.setRegProtocol("zookeeper");
//        config.setAddress("127.0.0.1:2181");
        config.setRegProtocol("local");
        return config;
    }


    @Bean
    public BasicServiceConfigBean baseServiceConfig() {
        BasicServiceConfigBean config = new BasicServiceConfigBean();
        config.setExport("demoMotanProtocol:8002");
        config.setGroup("motan-demo-rpc");
        config.setAccessLog(false);
        config.setShareChannel(true);
        config.setModule("motan-demo-rpc");
        config.setApplication("myMotanDemo");
        config.setRegistry("demoMotanRegistryConfig");
        return config;
    }
}
