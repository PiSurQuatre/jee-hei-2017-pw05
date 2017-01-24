package hei.tp05.core.service.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import hei.tp05.core.dao.ClientDAO;
import hei.tp05.core.entity.Client;
import hei.tp05.core.entity.Commande;
import hei.tp05.core.entity.Produit;
import hei.tp05.core.service.ClientService;

@Named
@Transactional
public class DataBaseInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataBaseInitializer.class);

    private static Random random = new SecureRandom();

    private static String[] allProduits = new String[] { "Hoverboard", "DeLorean", "Convecteur temporel", "Nike automatic", "AutoDry Coat", "Almanach", "Plutonium", "Freesbee"};

    @Inject
    private ClientService clientService;

    @Inject
    private ClientDAO clientDAO;


    @PostConstruct
    public void init() {
        clientDAO.deleteAll();
        List<Client> clients = getClients();
        for (Client client : clients) {
            clientService.saveClient(client);
        }
    }


    private List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("McFly", "Marty"));
        clients.add(new Client("McFly", "Georges"));
        clients.add(new Client("Brown", "Emmet"));
        clients.add(new Client("Tannen", "Biff"));
        clients.add(new Client("Clayton", "Clara"));
        setCommandes(clients);
        return clients;
    }


    private void setCommandes(List<Client> clients) {
        for (Client client : clients) {
            Set<Commande> commandes = new HashSet<>();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                LOGGER.info("Ajout d'une commande pour le client {}", client.getNom());
                commandes.add(new Commande(client));
            }
            setProduits(commandes);
            client.setCommandes(commandes);
        }
    }


    private void setProduits(Set<Commande> commandes) {
        for (Commande commande : commandes) {
            Set<Produit> produits = new TreeSet<>();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                String nomProduit = allProduits[random.nextInt(allProduits.length)];
                LOGGER.info("Ajout du produit {} à la commande", nomProduit);
                produits.add(new Produit(nomProduit, commande));
            }
            commande.setProduits(produits);
        }
    }
}
