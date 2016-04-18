package com.deere.dsfj.jdorder.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.OrderDao;
import com.deere.dsfj.jdorder.domain.Order;

/** This class interacts with database and provides the data for all order operations*/
@Repository(value="orderDao")
public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> searchOrdersOfCustomer(Integer customerNumber, String orderStatusCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrder(Integer orderNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}
