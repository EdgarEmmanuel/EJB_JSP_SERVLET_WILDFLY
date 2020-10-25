package module.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import module.entities.User;

@Stateless(name="user_impl")
public class UserImpl implements IUser {
	@PersistenceContext(unitName = "EJB_senForage")
	private EntityManager em;

	@Override
	public User getUserByParams(String login, String password) {
		User user = null;
		try {
			user = (User) em.createQuery("SELECT c FROM User c where c.email=:email "
					+ "and c.pasword=:password",User.class)
					.setParameter("email", login)
					.setParameter("password", password)
					.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		
		return user;
	}

}
