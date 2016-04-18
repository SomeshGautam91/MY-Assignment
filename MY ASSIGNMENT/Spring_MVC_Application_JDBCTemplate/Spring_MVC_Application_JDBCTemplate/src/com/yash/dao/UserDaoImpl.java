package com.yash.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;














import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.model.Contact;
import com.yash.model.User;
import com.yash.service.UserDaoInf;
import com.yash.utility.ConnectionProvider;

@Repository
public class UserDaoImpl implements UserDaoInf{
	
	 @Autowired
	 //private JdbcTemplate jdbcTemplate;
	 private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	
     @Override
	 public  User checkUser(User pr) throws SQLException, ClassNotFoundException {
		
		  String checkUserSql="SELECT * FROM user WHERE username=:username And password=:password";
		  
		  Map<String,Object> paramMap= new HashMap<String,Object>();
		  paramMap.put("username",(String)pr.getUsername());
		  paramMap.put("password",(String)pr.getPassword());
		  
		  return namedParameterJdbcTemplate.queryForObject(checkUserSql, paramMap, new UserMapper());
          
	}
	

	
     @Override
	public boolean SaveUser(User us) throws SQLException, ClassNotFoundException
	{
		 boolean msg;
		 
		 
		 String saveUserSql="INSERT INTO user (name,contact,email,username,password) VALUES (:name,:contact,:email,:username,:password)";
		 Map<String,Object> paramMap= new HashMap<String,Object>();
		 paramMap.put("name",(String)us.getName());
		 paramMap.put("contact",(Long)us.getContact());
		 paramMap.put("email",(String)us.getEmail());
		 paramMap.put("username",(String)us.getUsername());
		 paramMap.put("password",(String)us.getPassword());
		 int a2= namedParameterJdbcTemplate.update(saveUserSql, paramMap);
		 if(a2==1)
		  {
			 
			  msg=true;
		  }
		  else
		  {
			  msg=false;
		  }
		  return msg;
    }
	
     @Override
	public boolean SaveContact(Contact us,String username) throws SQLException, ClassNotFoundException
	{
		 boolean msg;
		 String saveContactSql="INSERT INTO contact (username,name,phone,email,address) VALUES (:username,:name,:phone,:email,:address)";
		 Map<String,Object> paramMap= new HashMap<String,Object>();
		 paramMap.put("username",username);
		 paramMap.put("name",us.getName());
		 paramMap.put("phone",(Long)us.getContact());
		 paramMap.put("email",us.getEmail());
		 paramMap.put("address",us.getAddress());
		 int a2= namedParameterJdbcTemplate.update(saveContactSql, paramMap);
		 if(a2==1)
		  {
			 
			  msg=true;
		  }
		  else
		  {
			  msg=false;
		  }
		  return msg;
				  
		  
	}
	
     @Override
	public List<Contact> ContactRetrive(Contact pr,String username) throws SQLException, ClassNotFoundException
	{
		 
    	 
    	
		  Map<String,Object> paramMap;
		  if(pr.getName()!=null)
		  {
			  String contactRetrieveSql="SELECT * FROM contact WHERE name=:name And username=:username";
			  paramMap= new HashMap<String,Object>();
			  paramMap.put("name",    (String)pr.getName());
			  paramMap.put("username",(String)username);
			  return namedParameterJdbcTemplate.query(contactRetrieveSql, paramMap, new ContactMapper());
		  

		  }
		 
		  else
		  {
			  String contactRetrieveSql="SELECT * FROM contact WHERE username=:username";
			  paramMap= new HashMap<String,Object>();
			  paramMap.put("username",username);
			  return namedParameterJdbcTemplate.query(contactRetrieveSql, paramMap, new ContactMapper());
		  } 
		  
		  
	}
	
     @Override
	public  boolean DeleteContact(int id) throws SQLException, ClassNotFoundException
	{
		 boolean msg;
		 
		 String deleteContactSql="DELETE FROM contact WHERE id=:id";
		 Map<String,Object> paramMap= new HashMap<String,Object>();
		 paramMap.put("id",id);
		 int a2=namedParameterJdbcTemplate.update(deleteContactSql, paramMap);
		 if(a2==1)
		 {
			  msg=true;
		 }
		 else
		 {
			  msg=false;
		 }
		 return msg;
		
	}
	
     @Override
	public boolean updateContact(Contact us) throws SQLException, ClassNotFoundException
	{
		  boolean msg;
		  
		  String updateContactSql="UPDATE contact SET name=:name,phone=:contact,email=:email,address=:address WHERE id=:id";
		  Map<String,Object> paramMap= new HashMap<String,Object>();
		  paramMap.put("name",us.getName());
		  paramMap.put("contact",us.getContact());
		  paramMap.put("email",us.getEmail());
		  paramMap.put("address",us.getAddress());
		  paramMap.put("id",us.getContact_id());
		  int a2=namedParameterJdbcTemplate.update(updateContactSql, paramMap);
          if(a2==1)
		  {
        	  msg=true;
		  }
		  else
		  {
			  msg=false;
		  }
		  return msg;
				  
		  
	}
	
     @Override
	public List<Contact> ContactRetrivebyid(Contact pr,String username) throws SQLException, ClassNotFoundException
	{
		   String contactRetrivebyidSql="SELECT * FROM contact WHERE id=:id";
		   Map<String,Object> paramMap= new HashMap<String,Object>();
		   paramMap.put("id",pr.getContact_id());
		   return namedParameterJdbcTemplate.query(contactRetrivebyidSql, paramMap, new ContactMapper());
		   
	}
	
   class UserMapper implements RowMapper<User>
   {

	  @Override
	   public User mapRow(ResultSet rs, int arg1) throws SQLException {
		  
		  User pr=new User();
		  pr.setName(rs.getString("name"));
		  pr.setContact(Long.parseLong(rs.getString("contact")));
		  pr.setEmail(rs.getString("email"));
		  pr.setUsername(rs.getString("username"));
		  pr.setPassword(rs.getString("password"));
		
		  return pr;
	}
	   
   }
   
   class ContactMapper implements RowMapper<Contact>
   {

	@Override
	public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
		
		 Contact one=new Contact();
		 one.setContact_id(rs.getInt("id"));
		 one.setName(rs.getString("name"));
		 one.setContact(Long.parseLong(rs.getString("phone")));
		 one.setEmail(rs.getString("email"));
		 one.setAddress(rs.getString("address"));
		 return one;
	}
	   
   }
     
}
