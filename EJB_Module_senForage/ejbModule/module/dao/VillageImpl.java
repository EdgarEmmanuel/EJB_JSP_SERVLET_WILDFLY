package module.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import module.entities.Village;

@Stateless(name="village_impl")
public class VillageImpl implements IVillage {
	@PersistenceContext(unitName = "EJB_senForage")
	private EntityManager em;
	
	@Override
	public List<Village> getAllVillage(){
		List<Village> allVillage = em.createQuery("SELECT c from Village c",Village.class).getResultList();
		return allVillage;
	}

	@Override
	public int insertVillage(Village vl) {
		int val =0 ;
		try {
			em.persist(vl);
			em.getTransaction().commit();
			val =1;
		} catch (Exception e) {
			val =0;
		}
		return val;
	}

	@Override
	public Village getOneByiD(int id) {
		return (Village)em.createQuery("SELECT c from Village c where c.id=:id",Village.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
