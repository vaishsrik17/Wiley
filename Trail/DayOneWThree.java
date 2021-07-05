package Trail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Users{
	int salary;
	String city;
	String name;
	public Users(String name, String city, int salary)
	{
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
}

class nameSort implements Comparator{
	public int compare(Object o1, Object o2)
	{
		Users user1 = (Users)o1;
		Users user2 = (Users)o2;
		return user1.city.compareTo(user2.city);
	}
}
	
class salarySort implements Comparator{
public int compare(Object o1, Object o2)
	{
		Users user1 = (Users)o1;
		Users user2 = (Users)o2;
		if(user1.salary>user2.salary)
			return 1;
		else
			return -1;
	}
}

public class DayOneWThree{
	public static void main(String[] args)
	{
		List userList = new ArrayList();
		userList.add(new Users("E1","MUM",25000));
		userList.add(new Users("E2","DEL",15000));
		userList.add(new Users("E3","BLR",30000));
		userList.add(new Users("E4","GUJ",35000));
		
		System.out.println("\nSort by Name");
		Collections.sort(userList, new nameSort());
		for(Object i : userList)
			System.out.println(((Users)i).name +" -- "+((Users)i).city);
		
		System.out.println("\nSort by Salary");
		Collections.sort(userList, new salarySort());
		for(Object i : userList)
			System.out.println(((Users)i).name+" -- "+((Users)i).city);
		
	}
}


