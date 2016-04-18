package com.yash.training.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.training.mapper.ContactRowMapper;
import com.yash.training.pojo.Contact;
import com.yash.training.pojo.User;

@Repository
public class UserJdbcTempleteDao implements UserDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveUser(User user) 
	{
		String sql="INSERT INTO user(name,contact,email,username,password) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{user.getName(),user.getContact(),user.getEmail(),user.getUsername(),user.getPassword()});

	}

	@Override
	public boolean getUser(String username, String password) {
	
		String sql="SELECT * FROM user where(username=? AND password=?)";
		if(jdbcTemplate.queryForInt(sql)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<Contact> saveContact(Contact contact, HttpSession session) {
		
		
		String insertContactSql="INSERT INTO contact(username,name,phone,email,address) VALUES(?,?,?,?,?)";
		String fetchContact="SELECT * FROM contact where username=?";
		jdbcTemplate.update(insertContactSql,new Object[]{(String)session.getAttribute("USERNAME"),contact.getName(),contact.getContact(),contact.getEmail(),contact.getAddress()});
		return jdbcTemplate.query(fetchContact,new Object[]{(String)session.getAttribute("USERNAME")},new ContactRowMapper());
	}

	@Override
	public List<Contact> getAllcontact(HttpSession session) {
		
		return null;
	}

	@Override
	public List<Contact> deleteContact(String uid, HttpSession session) {
		
		return null;
	}

	@Override
	public List<Contact> searchContact(String search, HttpSession session) {
	
		return null;
	}

	@Override
	public List<Contact> updateContact(Contact contact, HttpSession session) {
		
		return null;
	}

}
