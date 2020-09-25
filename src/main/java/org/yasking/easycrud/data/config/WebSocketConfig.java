package org.yasking.easycrud.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

// 注入一个ServerEndpointExporter Bean,该 Bean 会自动注册使用@ServerEndpoint 注解申明的 websocket endpoint。
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
