package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.OrderStatus;

/**This is an interface for OrderStatusDaoImpl*/
public interface OrderStatusDao{

    public List<OrderStatus> getAllOrderStatuses();
    public OrderStatus  findOrderStatusByCode(String code);   
}
