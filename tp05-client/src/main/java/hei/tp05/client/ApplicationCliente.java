package hei.tp05.client;

import hei.tp05.client.config.AppConfig;
import hei.tp05.contract.dto.ClientDTO;
import hei.tp05.contract.facade.ClientWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by pic on 31/01/2017.
 */
public class ApplicationCliente {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationCliente.class);




    public static void main(String[] args){

        LOGGER.info("Application lancée");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("hei.tp05.client.config");
        ClientWS cws = context.getBean(ClientWS.class);
        for(ClientDTO client:cws.getAllClients())
        {
            System.out.println(client.getNom()+" "+client.getPrenom());
        }
        context.close();

    }
}
