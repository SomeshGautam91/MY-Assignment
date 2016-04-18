package org.cdac.training.test;

import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.training.cdac.dao.MyLibrary;
import org.training.cdac.pojo.Book;
import org.training.cdac.pojo.BookIssue;
import org.training.cdac.pojo.Member;

public class TestLibrary 
{
	 static int i=114;
	public static void main(String [] args) throws Exception 
	{
		 int choice;
		 int memberId;
		 String name;
		 String contactNo;
		 String typeOfMember;
		 int  maxBooks;
		 String title;
		 String author;
		 Book b;
		 MyLibrary l;
		 MyLibrary z;
		 MyLibrary w;
		 Member m;
		 MyLibrary mb= new MyLibrary();
		 
//		ArrayList<Book> bl= new ArrayList<>();
//		ArrayList<Member> ml= new ArrayList<>();
//        ArrayList<BookIssue> bs= new ArrayList<>();
//		bs.add(new BookIssue("Core Java" ,1 ,new Date().toString(),(new Date()).toString(),5));
//		bs.add(new BookIssue("--",0,"--","--",0));
//		bs.add(new BookIssue("--",0,"--","--",0));
//		bs.add(new BookIssue("--",0,"--","--",0));
//		bs.add(new BookIssue("--",0,"--","--",0));
//	fileWriteBookIssue(bs);
		
		
		
	
	
		do
		{
			System.out.println("-----------Yash Library Management--------------");
			System.out.println("1.Book Issue");
			System.out.println("2.Book Return");
			System.out.println("3.Add Book");
			System.out.println("4.Remove Book");
			System.out.println("5.Add Member");
			System.out.println("6.Remove Member");
			System.out.println("7.Available books for Member");
			System.out.println("8.Available Books");
			System.out.println("9.Exit");
			System.out.println("-------------------------");
			System.out.println("Enter Choice");
			Scanner sc= new Scanner(System.in);
			choice=sc.nextInt();
			
			
			switch(choice)
			{
				case 1:System.out.println("Enter Title");
					    sc= new Scanner(System.in);
					    title=sc.nextLine();
					    System.out.println("Enter MemberId");
					    memberId=sc.nextInt();
					    l=fileRead();
					    z=fileReadMember();
					    w=fileReadBookIssue();
					    mb.BookIssue(title,l.getArrayListBook(),memberId,z.getArrayListMember(),w.getArrayListBookIssue());
					   break;
				case 2:System.out.println("Enter Return Book Title");
			    	   sc= new Scanner(System.in);
			           title=sc.next();
			           l=fileRead();
			           w=fileReadBookIssue();
			           mb.BookReturn(title,l.getArrayListBook(),w.getArrayListBookIssue());
			           break;
				case 3:System.out.println("Enter Title and Author");
						sc=new Scanner(System.in);
						title=sc.next();
						author=sc.next();
						l=fileRead();
						b=new Book(100+(l.getArrayListBook()).size()+1,title,author,1);
						mb.AddBook(b,l.getArrayListBook());
						break;
				case 4:System.out.println("Enter Title and Author");
					   sc=new Scanner(System.in);
				       title=sc.next();
				       author=sc.next();
				       l=fileRead();
				       b=new Book(i+1,title,author,1);
				       mb.RemoveBook(b,l.getArrayListBook());break;
				case 5://System.out.println("Enter MemberId");
						sc=new Scanner(System.in);
						//memberId=sc.nextInt();
						System.out.println("Enter Name");
						name=sc.next();
						System.out.println("Enter contactNo");
						contactNo=sc.next();
						System.out.println("Enter typeOfMember(Permanent or Temporary membership)");
						typeOfMember=sc.next();
						if(typeOfMember.equals("Permanent"))
						{
							maxBooks=5;
						}
						else
						{
							maxBooks=2;
						}
					
						l=fileReadMember();
						m=new Member(1+(l.getArrayListMember()).size(),name,contactNo,typeOfMember,maxBooks);
						mb.AddMember(m,l.getArrayListMember());
				        break;
				case 6:System.out.println("Enter Member Id");
				       sc= new Scanner(System.in);
				       memberId=sc.nextInt();
				       System.out.println("Enter Name");
				       name=sc.next();
				       l=fileReadMember();
				       mb.RemoveMember(l.getArrayListMember(),memberId,name);
				       break;
				case 7:System.out.println("Enter Member Id");
			           sc= new Scanner(System.in);
			           memberId=sc.nextInt();
			           l=fileReadMember();
			           mb.BooksforMember(l.getArrayListMember(),memberId);
					   break;
				case 8:l=fileRead();
					   mb.AvailableBooks(l.getArrayListBook());
				       break;
				default:System.out.println("Enter Valid Choice");
				
				
				
				
			}
			
		}while(choice!=9);
		
	}
	
public static MyLibrary fileRead() throws Exception
	{
		JSONParser parser = new JSONParser();
        Object data =(Object)parser.parse(new FileReader("C:\\Users\\somesh.kumar\\Desktop\\jsonBook.txt"));
		ArrayList<Object> obj=(ArrayList)data;
		ArrayList<Book> bl=new ArrayList<>();
		Iterator<Object> obj1=obj.iterator();
		while(obj1.hasNext())
		{
			JSONObject j=(JSONObject)obj1.next();
			long i=(Long)j.get("BookId");
			long k=(Long)j.get("Quantity");
			long l=(Long)j.get("MemberId");
			Book b= new Book((int)i,(String)j.get("Title"),(String)j.get("Auther"),(int)k,(int)l);
			bl.add(b);
		
			
		}
		MyLibrary l= new MyLibrary();
		l.setArrayListBook(bl);
		return l;
		
	}

public static void fileWrite(ArrayList<Book> obj) throws Exception
	{
		ArrayList<Object> books=new ArrayList<Object>();
		for (Object book :obj) {
		Book newBook=(Book)book;
		JSONObject jObj = new JSONObject();
		jObj.put("BookId",  newBook.getId()); 
		jObj.put("Title",   newBook.getTitle());
		jObj.put("Auther",  newBook.getAuthor());
		jObj.put("Quantity",newBook.getQuantity());
		jObj.put("MemberId",newBook.getMemberId());
		books.add(jObj);
	}
	FileWriter file= new FileWriter("C:\\Users\\somesh.kumar\\Desktop\\jsonBook.txt");
	file.write(books.toString());
	file.close();
	}

public static MyLibrary fileReadMember() throws Exception
{
	JSONParser parser = new JSONParser();
    Object data =(Object)parser.parse(new FileReader("C:\\Users\\somesh.kumar\\Desktop\\jsonMember.txt"));
	ArrayList<Object> obj=(ArrayList)data;
	ArrayList<Member> bl=new ArrayList<>();
	Iterator<Object> obj1=obj.iterator();
	while(obj1.hasNext())
	{
		JSONObject j=(JSONObject)obj1.next();
		long i=(Long)j.get("MemberId");
		long k=(Long)j.get("MaxNoOfBooks");
		Member m= new Member((int)i,(String)j.get("Name"),(String)j.get("ContactNo"),(String)j.get("TypeOfMember"),(int)k);
		bl.add(m);
	
		
	}
	MyLibrary l= new MyLibrary();
	l.setArrayListMember(bl);
	return l;
	
}



public static void fileWriteMember(ArrayList<Member> obj) throws Exception
{
	ArrayList<Object> members=new ArrayList<Object>();
	for (Object member:obj) {
	Member newMember=(Member)member;
	JSONObject jObj = new JSONObject();
	jObj.put("MemberId",    newMember.getMemberId()); 
	jObj.put("Name",        newMember.getName());
	jObj.put("ContactNo",   newMember.getContactNo());
	jObj.put("TypeOfMember",newMember.getTypeOfMember());
	jObj.put("MaxNoOfBooks",newMember.getMaxBooks());
	members.add(jObj);
}
FileWriter file= new FileWriter("C:\\Users\\somesh.kumar\\Desktop\\jsonMember.txt");
file.write(members.toString());
file.close();
}
public static MyLibrary fileReadBookIssue() throws Exception
{
	JSONParser parser = new JSONParser();
    Object data =(Object)parser.parse(new FileReader("C:\\Users\\somesh.kumar\\Desktop\\jsonBookIssue.txt"));
	ArrayList<Object> obj=(ArrayList)data;
	ArrayList<BookIssue> bl=new ArrayList<>();
	Iterator<Object> obj1=obj.iterator();
	while(obj1.hasNext())
	{
		JSONObject j=(JSONObject)obj1.next();
		long i=(Long)j.get("MemberId");
		long k=(Long)j.get("DaysRemaining");
		BookIssue m= new BookIssue((String)j.get("BookName"),(int) i,(String)j.get("IssueDate"),(String)j.get("ReturnDate"),(int)k);
		bl.add(m);
	
		
	}
	MyLibrary l= new MyLibrary();
	l.setArrayListBookIssue(bl);
	return l;
	
}

public static void fileWriteBookIssue(ArrayList<BookIssue> obj) throws Exception
{
	ArrayList<Object> members=new ArrayList<Object>();
	for (Object book:obj) {
	BookIssue newBook=(BookIssue)book;
	JSONObject jObj = new JSONObject();
	jObj.put("BookName",        newBook.getBookName()); 
	jObj.put("MemberId",        newBook.getMemberId());
	jObj.put("IssueDate",       newBook.getIssueDate());
	jObj.put("ReturnDate",      newBook.getReturnDate());
	jObj.put("DaysRemaining",   newBook.getDaysRemain());
	members.add(jObj);
}
FileWriter file= new FileWriter("C:\\Users\\somesh.kumar\\Desktop\\jsonBookIssue.txt");
file.write(members.toString());
file.close();
}
}
		
		
		
		
	


