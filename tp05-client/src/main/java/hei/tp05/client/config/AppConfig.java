package hei.tp05.client.config;

import java.io.IOException;
import java.util.Properties;

import hei.tp05.contract.facade.ClientWS;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public ClientWS clientWebService()
    {

        LOGGER.info("clientWebService()");
        JaxWsProxyFactoryBean jwspfb = new JaxWsProxyFactoryBean();
        jwspfb.setServiceClass(ClientWS.class);
        jwspfb.setAddress("http://localhost:8080/tp05-server/services/client");
        ClientWS cws = (ClientWS) jwspfb.create();
        LOGGER.info("ClientWS créé");
        return cws;
    }
}