package office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee implements Comparable<Employee> {
	
	String name;
	
	String title;
	
	Employee senior;
	
	public Employee(String name, String title) {
		this(name, title, null);
	}

	public Employee(String name, String title, Employee senior) {
		this.name = name;
		this.title = title;
		this.senior = senior;
	}

	@Override
	public String toString() {
		return name + " (" + title + ")";
	}

	@Override
	public int compareTo(Employee employee) {
		if (rank() == employee.rank())
			return title.compareTo(employee.title);
		return new Integer(rank()).compareTo(employee.rank());
	}
	
	public int rank() {
		return senior == null? 1: senior.rank() + 1;
	}
	
	public Set<Employee> subordinates(Collection<Employee> employees) {
		Set<Employee> subordinates = new HashSet<Employee>();
		for (Employee employee: employees)
			if (employee.senior == this)
				subordinates.add(employee);
		return subordinates;
	}
	
	public Set<Employee> allSubordinates(Collection<Employee> employees) {
		Set<Employee> subordinates = new HashSet<Employee>();
		for (Employee subordinate: subordinates(employees)) {
			subordinates.addAll(subordinate.allSubordinates(employees));
			subordinates.add(subordinate);
		}
		return subordinates;
	}

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>(); 
		
		Employee david = new Employee("David Wallace", "CFO"); employees.add(david);
		Employee michael = new Employee("Michael Scott", "Reg. Mgr.", david); employees.add(michael);
		
		Employee dwight = new Employee("Dwight Schrute", "Asst. Reg. Mgr.", michael); employees.add(dwight);
		Employee jim = new Employee("Jim Halpret", "Sales Rep.", michael); employees.add(jim);
		Employee andy = new Employee("Andy Bernard", "Sales Rep.", michael); employees.add(andy);
		
		Employee angela = new Employee("Angela Martin", "Sr. Acct.", michael); employees.add(angela);
		Employee oscar = new Employee("Oscar Martinez", "Acct.", angela); employees.add(oscar);
		Employee kevin = new Employee("Kevin Malone", "Acct.", angela); employees.add(kevin);
		
		Employee pam = new Employee("Pam Beesly", "Recpt.", michael); employees.add(pam);
		Employee kelly = new Employee("Kelly Kapoor", "Cust. Svc.", michael); employees.add(kelly);
		Employee toby = new Employee("Toby Flanderson", "HR", michael); employees.add(toby);
		Employee creed = new Employee("Creed Braton", "QA", michael); employees.add(creed);
		
		Collections.sort(employees);
		
		for (Employee employee: employees) {
			int rank = employee.rank();
			int subs = employee.allSubordinates(employees).size();
			System.out.format("%d. %s has %d subordinates\n", rank, employee, subs);
		}
	}

}

