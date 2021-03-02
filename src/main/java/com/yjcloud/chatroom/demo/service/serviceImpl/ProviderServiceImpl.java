package com.yjcloud.chatroom.demo.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import com.yjcloud.chatroom.demo.service.ProviderService;

// 也可以这样写，写接口的权限定类名
//@Service(interfaceName ="com.md.springboot.service.StudentService",version = "1.0.0",timeout= 15000)
//暴露出接口的类名.class，版本号，

@Service(version = "1.0.0")
@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
