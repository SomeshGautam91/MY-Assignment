import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Circle extends Shape {
	
	 public static void testClassMethod() 
	 {
	        System.out.println("The static method in Cat");
	 }
	 public void testInstanceMethod() 
	 {
	        System.out.println("The instance method in Cat");
	 }

	public static void main(String[] args) {
	
		Map<Integer,String> nameMap=new HashMap<>();
		nameMap.put(3,"Praveen");
		nameMap.put(1,"Sushant");
		nameMap.put(2,"Somesh");
		nameMap.put(4,"Somesh");
		
		List<String> nameList= new LinkedList<>();
		nameList.add("Somesh");
		nameList.add("Pradeep");
		nameList.add("Sunil");
		
		Set<String> nameSet= new HashSet<String>();
		nameSet.add("Pradeep");
		nameSet.add("Sunil");
		nameSet.add("Somesh");
		
		
		Iterator<String> nameItr=nameList.iterator();
		while(nameItr.hasNext())
		{
			System.out.println(nameItr.next());
		}
		
		System.out.println("----------------------------------");
		
		
		Iterator<String> nameItr2=nameSet.iterator();
		while(nameItr2.hasNext())
		{
			System.out.println(nameItr2.next());
		}
		
		System.out.println("----------------------------------");
		
		
		Set<Entry<Integer,String>> entrySet	=nameMap.entrySet();
		Iterator<Entry<Integer,String>> itr=entrySet.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	
		
		
	}

}
