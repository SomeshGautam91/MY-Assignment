package com.yash.hibernateapplicationusingmanytomany.tester;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinFragment;

import com.yash.hibernateapplicationusingmanytomany.model.Projects;
import com.yash.hibernateapplicationusingmanytomany.model.User;

public class Tester 
{

	public static void main(String[] args)
	{
		String id=null;
		AnnotationConfiguration configuration= new AnnotationConfiguration();
		SessionFactory factory=configuration.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		User user1= new User();
		user1.setName("Somesh");
		
		
		User user2= new User();
		user2.setName("Paul");
		
		/*User user3= new User();
		user3.setName("John");*/
		
		Projects project1=new Projects();
		project1.setName("John Deere");
		
	/*	Projects project2=new Projects();
		project2.setName("Sigma");
		
		Projects project3=new Projects();
		project3.setName("IBM");*/
		
		List<User> list_Of_user1=new ArrayList<>();
		list_Of_user1.add(user1);
		
		
	/*	List<User> list_Of_user2=new ArrayList<>();
		list_Of_user2.add(user1);
		list_Of_user2.add(user3);
		
		List<User> list_Of_user3=new ArrayList<>();
		list_Of_user3.add(user2);*/
		
		List<Projects> list_Of_projects1= new ArrayList<>();
		list_Of_projects1.add(project1);
		
	/*	List<Projects> list_Of_projects2= new ArrayList<>();
		list_Of_projects2.add(project1);
		list_Of_projects2.add(project2);
		list_Of_projects2.add(project3);
		
		List<Projects> list_Of_projects3= new ArrayList<>();
		list_Of_projects3.add(project2);*/
		
		
		user1.setListOfProjects(list_Of_projects1);
		/*user2.setListOfProjects(list_Of_projects2);
		user3.setListOfProjects(list_Of_projects3);*/
		
		
		project1.setListOfUsers(list_Of_user1);
	/*	project2.setListOfUsers(list_Of_user3);
		project3.setListOfUsers(list_Of_user2);*/
		
		
		/*Criteria criteria=session.createCriteria(User.class);
		List<User> usersList=criteria.add(Restrictions.like("name","S%")).list();
		
		for(User user:usersList)
		{
			System.out.println(user.getId()+"-----"+user.getName());
		}
		long count=(Long)session.createCriteria(User.class).setProjection(Projections.rowCount()).add(Restrictions.like("name","S%")).uniqueResult();
		System.out.println(count)*/;
		
		
		
		//Using NamedNativeQuery
		/*Query query=session.getNamedQuery("User.byName");
		List<User> userList=query.list();
		for(User user :userList)
		{
			System.out.println(user.getId()+"-------"+user.getName());
		}
		*/
		
		//Saving records into table
		//session.save(user1);
		/*session.save(user2);*/
		/*session.save(user3);
		
		
		session.save(project1);
		session.save(project2);
		session.save(project3);*/
		
		/*List<User> userList2=session.createCriteria(User.class).add(Restrictions.like("name", "S%")).list();*/
		
		List<Projects> subCriteria = session.createCriteria(Projects.class)
		        .createCriteria("listOfUsers", JoinFragment.INNER_JOIN)
		        .add(Restrictions.eq("name", "Somesh")).list();
		
		//User user=(User)session.get(User.class, new Integer(1)); 
		
		for(Projects project:subCriteria)
		{
			/*for(Projects project:user.getListOfProjects())
			{
				System.out.println(project.getName());
			}*/
			System.out.println(project.getName());
		}
		
		//deleting records from User table
		/*Query query1=session.createQuery("from User");
		List<User> users=query1.list();
		for(User user:users)
		{
			session.delete(user);
		}*/
		
		/*Query query=session.createQuery("delete User u WHERE u.id=:id");
		query.setInteger("id",7);
		int result=query.executeUpdate();
		if(result>0)
		{
			System.out.println("Deleted Successfully");
		}*/
		
		
	    //Fetching record based on a particular Id
		//String userName=(String)session.createQuery("SELECT u.name FROM User u WHERE u.id=:id").setInteger("id",3).uniqueResult();
		
		
		//Fetching multiple column from User table
		/*Query query2=session.createQuery("SELECT u.id,u.name FROM User u");
	    List<Object[]> rows=query2.list();
	    
	    for (Object[] objects : rows)
	    {
	    	System.out.println(" ------------------- ");
	        System.out.println("id: " + objects[0]);
	        System.out.println("name: " + objects[1]);
		}*/
	    
		
	    
		
		//fetching all records from User Table
		/*Query query3=session.createQuery("from User");
	     List<String> nameList=query3.list();
		System.out.println(nameList.size());
		for (String string : nameList) 
		{
			System.out.println(nameList);
		}*/
		//System.out.println(userName);
		
		
		transaction.commit();
		session.close();
		factory.close();
		
		
	}

}
