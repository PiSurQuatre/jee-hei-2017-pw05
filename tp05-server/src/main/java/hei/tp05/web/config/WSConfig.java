package hei.tp05.web.config;

import hei.tp05.contract.facade.ClientWS;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@Configuration
@ComponentScan("hei.tp05.web.service.impl")
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class WSConfig {
    @Inject
    private ClientWS clientWS;

    @Inject
    private Bus bus;

    @Bean
    public Endpoint Endpoint(){
        EndpointImpl endPointImpl = new EndpointImpl(bus, clientWS);
        endPointImpl.setAddress("/client");
        endPointImpl.publish();
        return endPointImpl;
    }

}
