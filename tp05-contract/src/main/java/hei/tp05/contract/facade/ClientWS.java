package hei.tp05.contract.facade;

import hei.tp05.contract.dto.ClientDTO;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ClientWS {

    public List<ClientDTO> getAllClients();

    public void saveClient(ClientDTO clientToSave);
}
