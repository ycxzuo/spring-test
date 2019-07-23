package com.yczuoxin.springboot.test13.config;

import com.yczuoxin.springboot.test13.websocket.ChatRoomServerEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebsocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public ChatRoomServerEndpoint serverEndpoint(){
        return new ChatRoomServerEndpoint();
    }

}
