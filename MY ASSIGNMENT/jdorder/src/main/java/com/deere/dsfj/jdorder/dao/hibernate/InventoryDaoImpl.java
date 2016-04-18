package com.deere.dsfj.jdorder.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.InventoryDao;
import com.deere.dsfj.jdorder.domain.Inventory;

/**This class interacts with database and returns the inventory data  */
@Repository(value="inventoryDao")
public class InventoryDaoImpl implements InventoryDao{

	@Override
	public List<Inventory> searchInventory(String description) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
