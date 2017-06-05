package dao;

import java.util.List;

import entity.Pic;

public interface PicDao {
	public void add(Pic pic) throws Exception;

	 public List<Pic> findBySid(String id)throws Exception;
   
    public void delete(int id) throws Exception;
    
   
}
