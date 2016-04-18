package com.yash.sumcomponent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;




import com.yash.sumcomponent.model.User;

@Repository 
public class UserDaoImpl implements UserDaoIfc {

	@Autowired
	 private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public List<User> fetchAllUser() 
	{
		String sqlToFetchAllUser="SELECT * FROM USERS";
		return namedParameterJdbcTemplate.query(sqlToFetchAllUser,new UserMapper());
		
	}
	
	@Override
	public List<User> InsertUser(User user) 
	{
		 List<User> userList=null; 
		 String sqlForInsertUser="INSERT INTO users(id,name,location) VALUES(:id,:name,:location)";
		 Map<String,Object> paramMap= new HashMap<String,Object>();
		 paramMap.put("id",user.getUserId());
		 paramMap.put("name",user.getName());
		 paramMap.put("location",user.getLocation());
		 int noOfRowUpdated=namedParameterJdbcTemplate.update(sqlForInsertUser, paramMap);
		 if(noOfRowUpdated==1)
		 {
			 userList=fetchAllUser();
			 
		 }
		 return userList;
		
	}
	
	@Override
	public List<User> searchUserByName(User user) 
	{
		
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap.put("username",user.getName());
			paramMap.put("location",user.getLocation());
			String query=" SELECT * FROM users WHERE name =:username OR location =:location";
			return  namedParameterJdbcTemplate.query(query, paramMap, new UserMapper());
			
		

		
	}
	@Override
	public List<User> searchUserById(User user) 
	{
		
		Map<String,Object> paramMap= new HashMap<String,Object>();
		paramMap.put("id",user.getUserId());
		String query=" SELECT * FROM users WHERE id =:id";
		return  namedParameterJdbcTemplate.query(query, paramMap, new UserMapper());
		
		
	}
	
	
	
	@Override
	public List<User> deleteUser(int id) {
		
			List<User> userList=null; 
			String deleteContactSql="DELETE FROM users WHERE id=:id";
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap.put("id",id);
			int noOfRowUpdated=namedParameterJdbcTemplate.update(deleteContactSql, paramMap);
			if(noOfRowUpdated==1)
			{
				userList=fetchAllUser();
			}
			return userList;
	}
	@Override
	public List<User> updateUser(User user) 
	{
			List<User> userList=null; 
			String deleteContactSql="UPDATE users SET name=:name,location=:location WHERE id=:id";
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap.put("id",user.getUserId());
			paramMap.put("name",user.getName());
			paramMap.put("location",user.getLocation());
			int noOfRowUpdated=namedParameterJdbcTemplate.update(deleteContactSql, paramMap);
			System.out.println(noOfRowUpdated);
			if(noOfRowUpdated==1)
			{
				userList=fetchAllUser();
			}
			return userList;
	}
	
	class UserMapper implements RowMapper<User>
	{

		  @Override
		   public User mapRow(ResultSet rs, int arg1) throws SQLException 
		  {
			  
			  User user=new User();
			  user.setName(rs.getString("name"));
			  user.setLocation(rs.getString("location"));
			  user.setUserId(rs.getInt("id"));
			  return user;
		  }

	}

	


	
	
	
}
