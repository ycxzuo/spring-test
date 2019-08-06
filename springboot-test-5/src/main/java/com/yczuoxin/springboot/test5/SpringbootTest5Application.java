package com.yczuoxin.springboot.test5;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootTest5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest5Application.class, args);
    }

    @Bean
    public static WebServerFactoryCustomizer<TomcatServletWebServerFactory> webServerFactory() {
        return (SpringbootTest5Application::customize);
    }

    public static void customize(TomcatServletWebServerFactory factory){


        // 修改定制化 tomcat 中的 connector，此方法会导致 factory.setPort(8888) 失效
        factory.addConnectorCustomizers(SpringbootTest5Application::customize);

        factory.setPort(8888);
        factory.setProtocol(Http11Nio2Protocol.class.getName());
        factory.setContextPath("");

        // 新增定制化 tomcat 中的 connector
        Connector connector = new Connector();
        connector.setPort(8887);
        factory.addAdditionalTomcatConnectors(connector);
    }

    public static void customize(Connector connector){
        connector.setPort(8889);
    }
}