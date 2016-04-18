package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.Order;

public interface OrderDao {
	
public List<Order> searchOrdersOfCustomer(Integer customerNumber, String orderStatusCode);
    
    public void add(Order order);
    
    public void update(Order order);
    
    public Order getOrder(Integer orderNumber);

}
