package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.LineItem;

/** This is an interface for LineItemImpl*/
public interface LineItemDao{
    public void addLineItems(LineItem lineItem);
    public void update(LineItem lineItem);
    public List<LineItem> getLineItems(Integer orderNumber);
    public void delete(LineItem lineItem) ;
}
