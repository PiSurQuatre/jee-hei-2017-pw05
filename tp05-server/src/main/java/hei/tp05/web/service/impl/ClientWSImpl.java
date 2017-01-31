package hei.tp05.web.service.impl;

import hei.tp05.contract.dto.ClientDTO;
import hei.tp05.contract.facade.ClientWS;
import hei.tp05.core.entity.Client;
import hei.tp05.core.service.ClientService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Named("clientWS")
@WebService(endpointInterface = "hei.tp05.contract.facade.ClientWS")
public class ClientWSImpl implements ClientWS
{

    @Inject
    ClientService clientService;

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> listeClients = clientService.findAll();
        List<ClientDTO> listeClientsDTO = new ArrayList<ClientDTO>();
        for(Client client:listeClients){
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setPrenom(client.getPrenom());
            clientDTO.setNom(client.getNom());
            listeClientsDTO.add(clientDTO);
        }
        return listeClientsDTO;
    }

    /*public List<ClientDTO> getAllClientsBis() {
        return clientService.findAll()
                .stream()
                .map(c->new ClientDTO(c.getNom(), c.getPrenom()))
                .collect(Collectors.toList());

    }*/

    @Override
    public void saveClient(ClientDTO clientToSave) {
        Client client = new Client();
        client.setPrenom(clientToSave.getPrenom());
        client.setNom(clientToSave.getNom());
        clientService.saveClient(client);
    }
}
