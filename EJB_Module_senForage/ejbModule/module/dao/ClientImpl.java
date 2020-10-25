package module.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import module.entities.Client;

@Stateless(name = "client_impl")
public class ClientImpl implements IClient{
	@PersistenceContext(unitName = "EJB_senForage")
	private EntityManager em;
	
	@Override
	public List<Client> getAllClient(){
		List<Client> allClient = em.createQuery("SELECT c from Client c",Client.class).getResultList();
		return allClient;
	}

	@Override
	public int insertClient(Client client) {
		int val=0;
		try {
			em.persist(client);
			val =1;
		} catch (Exception e) {
			val = 0;
		}
		
		return val;
	}

}
