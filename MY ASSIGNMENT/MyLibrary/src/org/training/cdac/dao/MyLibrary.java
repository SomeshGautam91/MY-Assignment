package org.training.cdac.dao;
import java.util.*;


import org.cdac.training.test.TestLibrary;
import org.json.simple.JSONObject;
import org.training.cdac.pojo.Book;
import org.training.cdac.pojo.Member;
import org.training.cdac.pojo.BookIssue;
import java.util.Date;

public class MyLibrary  {
	
	private static ArrayList<Book> bAL;
	private static ArrayList<Member> mAL;
	private static ArrayList<BookIssue> b;
	
	public ArrayList<BookIssue> getArrayListBookIssue() {
		return b;
	}
	public void setArrayListBookIssue(ArrayList<BookIssue> b) {
		MyLibrary.b = b;
	}
	public void setArrayListBook(ArrayList<Book> bl)
	{
		this.bAL=bl;
	}
	public void setArrayListMember(ArrayList<Member> ml)
	{
		this.mAL=ml;
	}
	public ArrayList<Book> getArrayListBook()
	{
		return bAL;
	}
	public ArrayList<Member> getArrayListMember()
	{
		return mAL;
	}
	public void BookIssue(String title,ArrayList<Book> bAL,int p, ArrayList<Member> mAL,ArrayList<BookIssue> bs) throws Exception
	{
		int n;	
		int h;
		boolean a=false;
		boolean d=false;
		Iterator<Book> itr=bAL.iterator();
		Iterator<Member> itm=mAL.iterator();
		Iterator<BookIssue> itb=bs.iterator();
		while(itm.hasNext())
		{
			Member m=itm.next();
			if(m.getMemberId()==p)
			{	
				a=true;
				while(itr.hasNext())
				{
					Book b= itr.next();
					if(b.getTitle().equals(title) && b.getQuantity()>0 && m.getMaxBooks()>0)
					{
						d=true;
						Date d1=new Date();
						int day=d1.getDay();
						int month=d1.getMonth();
						int year=d1.getYear();
						String date=month+"/"+day+"/"+year;
						
						Date d2=new Date();
						d2.setDate(d1.getDate()+10);
						long diff=((d2.getTime()-d1.getTime())/1000)/86400;
						BookIssue bi= new BookIssue(b.getTitle(),m.getMemberId(),date,d2.toString(),(int)diff);
						bs.add(bi);
						n=b.getQuantity();
						h=m.getMaxBooks();
						b.setQuantity(n-1);
						m.setMaxBooks(h-1);
						b.setMemberId(p);
						System.out.println(" Book "+ b.getTitle() + " Issued to " + m.getName());
					}
				}
			}
		}
		if(d==true)
		{
			TestLibrary.fileWrite(bAL);	
			TestLibrary.fileWriteMember(mAL);
			TestLibrary.fileWriteBookIssue(bs);
		}
		else
		{
			System.out.println("Sorry...Book can't be Issued");
		}
		if(a==false)
		{
			System.out.println("You are Not a Registered Member");
		}
	
		
	}
	public void BookReturn(String title,ArrayList<Book> bAL,ArrayList<BookIssue> bs) throws Exception
	{
		int n;	
		Iterator<Book> itr=bAL.iterator();
		Iterator<BookIssue> its=bs.iterator();
		while(itr.hasNext())
		{
			Book b= itr.next();
			if(b.getTitle().equals(title))
			{
				n=b.getQuantity();
				b.setQuantity(n+1);
			
				
			}
		}
		while(its.hasNext())
		{
			BookIssue b=its.next();
			if(b.getBookName().equals(title))
			{
				bs.remove(b);
				break;
			}
		}
		TestLibrary.fileWrite(bAL);	
		TestLibrary.fileWriteBookIssue(bs);
		System.out.println("Book return successfully");
	}
	public void AddBook(Book bk,ArrayList<Book> bAL) throws Exception
	{
		int n;	
		Iterator<Book> itr=bAL.iterator();
		while(itr.hasNext())
		{
			Book b= itr.next();
			if(b.getTitle().equals(bk.getTitle()) && b.getAuthor().equals(bk.getAuthor()))
			{
				n=b.getQuantity();
				b.setQuantity(n+1);
			
				
			}
			
		}
		bAL.add(bk);
		TestLibrary.fileWrite(bAL);	
		System.out.println("Book added Successfully");
	}
	public void RemoveBook(Book bk,ArrayList<Book> bAL) throws Exception
	{
		int n;	
		boolean x=false;
		Iterator<Book> itr=bAL.iterator();
		while(itr.hasNext())
		{
			Book b= itr.next();
			if(b.getTitle().equals(bk.getTitle()))
			{
				x=true;
				n=b.getQuantity();
				b.setQuantity(n-1);
			
				
			}
			
		}
		if(x==true)
		{
			TestLibrary.fileWrite(bAL);
			System.out.println("Book Removed Successfully");
		}
		else
		{
			System.out.println("Book with Title "+ bk.getTitle()+"doesn't Exist");
		}
	}
	public void AvailableBooks(ArrayList<Book> bAL) throws Exception
	{
		int n=0;

		Iterator<Book> itr=bAL.iterator();
		while(itr.hasNext())
		{
			Book b= itr.next();
			n+=b.getQuantity();

		}
		
		System.out.println("Total Available Books are:"+ n);
		
		
	}
	public void AddMember(Member mk,ArrayList<Member> mAL) throws Exception
	{
		int n;	
		boolean b=false;
		Iterator<Member> itr=mAL.iterator();
		while(itr.hasNext())
		{
			Member m = itr.next();
			if(m.getMemberId()==mk.getMemberId())
			{
				System.out.println("U are Already Registered");
				b=true;
			
				
			}
			
		}
		if(b==false)
		{
			mAL.add(mk);
			TestLibrary.fileWriteMember(mAL);
			System.out.println("Thank you for Registration");
		}
	}
	public void RemoveMember(ArrayList<Member> mAL,int memberId,String name) throws Exception
	{
		
		boolean b=false;
		Iterator<Member> itr=mAL.iterator();
		while(itr.hasNext())
		{
			Member m = itr.next();
			if(m.getMemberId()==memberId && m.getName().equals(name))
			{
				b=true;
				mAL.remove(m);
			
				
			}
			
		}
		if(b==true)
		{
			TestLibrary.fileWriteMember(mAL);
			System.out.println("Member is No longer Available");
		}
		else
		{
			System.out.println("Member with Id="+ memberId + "and Name=" + name +"does not exist" );
		}
	}
	public void BooksforMember(ArrayList<Member> mAL,int memberId) throws Exception
	{
		int n;
		boolean b=false;
		Iterator<Member> itr=mAL.iterator();
		while(itr.hasNext())
		{
			Member m = itr.next();
			if(m.getMemberId()==memberId )
			{
				b=true;
				System.out.println(" Member With id " + memberId + " have " + m.getMaxBooks()+ " books " );
				break;
				
			}
			
		}
		if(b==false)
		{
			System.out.println("Member is Not Available");
		}
		
	}
}
