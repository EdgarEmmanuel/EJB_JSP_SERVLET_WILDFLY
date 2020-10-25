package module.dao;

import java.util.List;

import javax.ejb.Local;

import module.entities.Village;

@Local
public interface IVillage {
	public int insertVillage(Village vl);
	public List<Village> getAllVillage();
	public Village getOneByiD(int id);
}
