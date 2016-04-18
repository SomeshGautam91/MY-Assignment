package com.yash.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.yash.training.pojo.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet resultSet, int rowNumber) throws SQLException 
	{
		Contact contact=new Contact();
    	contact.setId(resultSet.getInt(1));
    	contact.setName(resultSet.getString(3));
    	contact.setContact(resultSet.getLong(4));
    	contact.setEmail(resultSet.getString(5));
    	contact.setAddress(resultSet.getString(6));
		return contact;
		
	}

}
