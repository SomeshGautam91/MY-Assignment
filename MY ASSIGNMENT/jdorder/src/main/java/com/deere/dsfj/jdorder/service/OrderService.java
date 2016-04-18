package com.deere.dsfj.jdorder.service;

import java.util.List;

import org.springframework.validation.Errors;

import com.deere.dsfj.jdorder.domain.Order;
import com.deere.dsfj.jdorder.form.OrderForm;
import com.deere.dsfj.jdorder.form.OrderSearchForm;

/**This is an interface for OrderServiceImpl*/
public interface OrderService{
    public List<Order> searchOrdersOfCustomer(OrderSearchForm orderSearchCriteria);
    public Order add(OrderForm orderForm, Errors errors);
    public Order update(OrderForm orderForm, Errors errors);
    public Order getOrder(Integer orderNumber);
}
