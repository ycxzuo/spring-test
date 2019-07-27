package com.yczuoxin.springboot.test14.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WebservicesConfiguration extends WsConfigurerAdapter {

    @Bean("user")
    public Wsdl11Definition userWsdlDefinition(XsdSchema userXsdSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

        wsdl11Definition.setPortTypeName("UserServicePort");
        wsdl11Definition.setLocationUri("/web-service");
        wsdl11Definition.setTargetNamespace("http://www.yczuoxin.com/schemas");
        wsdl11Definition.setSchema(userXsdSchema);

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema userXsdSchema() {
        return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/user.xsd"));
    }

}
