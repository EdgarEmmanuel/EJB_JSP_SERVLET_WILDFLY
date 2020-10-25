package module.dao;

import javax.ejb.Local;

import module.entities.User;

@Local
public interface IUser {
	public User getUserByParams(String login,String password);
}
