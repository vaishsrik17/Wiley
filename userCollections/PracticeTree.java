//Problem Statement
//Case 1 - expected sort : 1,2,User{1,"User1"}, User{2,"User2"} (user by id),Hello,Hi
//Case 1 - expected sort : Hello, Hi, User{1, "User1"}, User{2,"User2"} (user by name),1,2
//Case 1 - expected sort : User{1,"Adam"},Hello,Hi,User{2,"User2"},1,2


package userCollections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PracticeTree {
	public static void main(String[] args) {
		//Case 1
		//Set<Object> set = new TreeSet<>(new SortOneNumFirst());
		//Case 2
		Set<Object> set = new TreeSet<>(new SortTwoStringFirst());				
		//Case 3
		//Set<Object> set = new TreeSet<>(new SortThreeStringsFirst());
		set.add(new Integer(2));
		set.add(new Integer(1));
		set.add(new user(101,"Shivesh"));
		set.add(new user(102,"Pushpa"));
		set.add(new user(103,"Rajath"));
		set.add(new user(104,"Harish"));
		set.add("Hi");
		set.add("Hello");
		set.add("What's up");
		set.forEach(System.out::println);
	}
}

class user {
    private int id;
    private String name;
    public user(){
    }
    public user(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
	public String toString() {
		return "User Id:" + id + " --- User Name:"+name;
	}
}

class SortOneNumFirst implements Comparator<Object> {
	private Object obj;
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    @Override
    public String toString() {
        return obj+"";
    }
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Integer)
		{
			if(o2 instanceof Integer)
			{
				int i = (int)o1;
				int j = (int)o2;
				return i-j;
			}
			else 
				return -1;
		}
		else if(o1 instanceof user)
		{
			if(o2 instanceof user)
			{
				int id1 = ((user)o1).getId();
				int id2 = ((user) o2).getId();
				return id1-id2;
			}
			else 
				return 1;
		}
		else if(o1 instanceof String)
		{
			if(o2 instanceof String)
			{
				String s1 = (String)o1;
				String s2 = (String)o2;
				return s1.compareTo(s2);
			}
			else 
				return 1;
		}
		return 0;
	}
	
}
class  SortTwoStringFirst implements Comparator<Object>{
	private Object obj;
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    @Override
    public String toString() {
        return obj+"";
    }
    @Override
	public int compare(Object o1, Object o2) {
    	if(o1 instanceof String)
		{
			if(o2 instanceof String)
			{
				String s1 = (String)o1;
				String s2 = (String)o2;
				return s1.compareTo(s2);
			}
			else 
				return -1;
		}
		else if(o1 instanceof user)
		{
			if(o2 instanceof user)
			{
				int id1 = (int)((user) o1).getId();
				int id2 = (int)((user) o2).getId();
				return id1-id2;
			}
			else 
				return -1;
		}
		else if(o1 instanceof Integer)
		{
			if(o2 instanceof Integer)
			{
				int i = (int)o1;
				int j = (int)o2;
				return i-j;
			}
			else 
				return 1;
		}
		return 0;
	}
	
}

class SortThreeStringsFirst implements Comparator<Object> {
	private Object obj;
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    @Override
    public String toString() {
        return obj+"";
    }
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Integer)
		{
			if(o2 instanceof Integer)
			{
				int i = (int)o1;
				int j = (int)o2;
				return i-j;
			}
			else 
				return -1;
		}
		else if(o1 instanceof String)
		{
			String s1 = (String)o1;
			if(o2 instanceof String)
			{
				String s2 = (String)o2;
				return s1.compareTo(s2);
			}
			else if(o2 instanceof user)
			{
				String s2 = ((user)o2).getName();
				return s1.compareTo(s2);
			}
			else
				return -1;
		}
		else if(o1 instanceof user)
		{
			String s1 = ((user)o1).getName();
			if(o2 instanceof String)
			{
				String s2 = (String)o2;
				return s1.compareTo(s2);
			}
			else if(o2 instanceof user)
			{
				String s2 = ((user)o2).getName();
				return s1.compareTo(s2);
			}
			else
				return -1;
		}
		return 0;
	}	
}

