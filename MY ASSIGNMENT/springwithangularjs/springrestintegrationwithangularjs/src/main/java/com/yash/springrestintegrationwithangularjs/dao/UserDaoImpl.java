/**
 * 
 */
package com.yash.springrestintegrationwithangularjs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.springrestintegrationwithangularjs.model.User;

/**
 * @author somesh.kumar
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	List<User> listOfUsers=null;
	
	/* (non-Javadoc)
	 * @see com.yash.springrestintegrationwithangularjs.dao.UserDao#fectAllUsers()
	 */
	public List<User> fetchAllUsers() {
		
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Query query=session.createQuery("from User");
		listOfUsers=query.list();
		transaction.commit();
		session.close();
		return listOfUsers;
	}

	public List<User> insertUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return fetchAllUsers();
	}

	public List<User> updateUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		System.out.println("user ID at dao------"+user.getId());
		session.update(user);
		transaction.commit();
		session.close();
		return fetchAllUsers();
	}

	public List<User> deleteUser(int index) {
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Query query=session.createQuery("DELETE from  User where id=:Id");
		query.setParameter("Id",index);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		transaction.commit();
		session.close();
		return fetchAllUsers();
	}

}
