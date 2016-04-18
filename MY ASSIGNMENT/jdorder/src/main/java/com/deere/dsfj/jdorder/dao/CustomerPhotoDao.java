package com.deere.dsfj.jdorder.dao;

import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.CustomerPhoto;

/** This is an interface for CustomerPhotoDaoImpl*/
public interface CustomerPhotoDao{
	
    public void add(CustomerPhoto customerPhoto);
    public void update(CustomerPhoto customerPhoto);
    public void delete(CustomerPhoto customerPhoto); 
    public CustomerPhoto getCustomerPhoto(Customer customer);
    public CustomerPhoto getCustomerPhoto(String pathOnServer);
    
}
