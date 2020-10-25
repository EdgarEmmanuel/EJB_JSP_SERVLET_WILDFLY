package module.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GetEntity {
	@PersistenceContext(unitName = "EJB_senForage")
	private static EntityManager entity ;
	
	public static EntityManager getEntity() {
		return entity;
	}
	
}
