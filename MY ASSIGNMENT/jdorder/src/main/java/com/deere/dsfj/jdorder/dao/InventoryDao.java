package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.Inventory;

/** This is an interface for InventoryDaoImpl*/
public interface InventoryDao{

    public List<Inventory> searchInventory(String description);
}
