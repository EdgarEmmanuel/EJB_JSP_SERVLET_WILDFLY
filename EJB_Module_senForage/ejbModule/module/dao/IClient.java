package module.dao;

import java.util.List;

import javax.ejb.Local;

import module.entities.Client;

@Local
public interface IClient {
	public int insertClient(Client client);
	public List<Client> getAllClient();
}
