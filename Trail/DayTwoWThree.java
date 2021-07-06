package Trail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class UserAll{
	String id;
	String userName;
	
	public UserAll(String id, String userName)
	{
		this.id = id;
		this.userName = userName;
	}
}

class Address {
	String city;
	String zipCode;
	
	public Address(String city, String zipCode)
	{
		this.city = city;
		this.zipCode = zipCode;
	}
}

class Project {
	int projectId;
	String name;
	double budget;
	
	public Project(int projectId, String name, double budget)
	{
		this.projectId = projectId;
		this.name = name;
		this.budget = budget;
	}
}

class Emp extends UserAll {
	Address address;
	Project project;
	double salary;
	
	public Emp(String id, String userName, Address address, Project project, double salary)
	{
		super(id,userName);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}
}

class EmpSort implements Comparator{
public int compare(Object o1, Object o2)
	{
		Emp emp1 = (Emp)o1;
		Emp emp2 = (Emp)o2;
		if(emp1.salary>emp2.salary)
			return 1;
		else
			return -1;
	}
}

public class DayTwoWThree {

	public static void main(String[] args) {
		
		List<UserAll> user = new ArrayList<>();
	
		user.add(new UserAll("1001","Suresh"));
		user.add(new UserAll("1002","Riya"));
		user.add(new Emp("1003","Vaibhav",new Address("Bengaluru","560070"), new Project(101, "Generics", 2500),820));
		user.add(new Emp("1004","Shruthi",new Address("Mumbai","400008"), new Project(101, "Generics", 2500),550));
		user.add(new Emp("1005","Sucheth",new Address("Chennai","600011"), new Project(101, "Generics", 2500),630));
		user.add(new Emp("1006","Vineeth",new Address("Pune","111045"), new Project(101, "Generics", 2500),680));
		user.add(new UserAll("1007","Suchithra"));
		
		List<Emp> empList = new ArrayList<>();
		double cost = 0;
		for(UserAll i : user)
			if(i instanceof Emp)
			{
				empList.add((Emp)i);
				cost += ((Emp)i).salary;
			}	
		
		Collections.sort(empList, new EmpSort());
		double projBudget = empList.get(0).project.budget;
		while(cost > projBudget)
		{	
			cost -= empList.get(0).salary;
			empList.remove(0);
		}	
	
		for(Emp i : empList)
			System.out.println(i.userName+" --- "+i.project.projectId+" --- "+i.salary);
	}

}
