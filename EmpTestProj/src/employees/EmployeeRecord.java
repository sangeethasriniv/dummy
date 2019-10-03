package employees;
import java.util.*;
public class EmployeeRecord implements Comparable<EmployeeRecord>{
	public int id=0;
	public static int empcount = 0;
	String name;
	public int age;
	public int salary;
	public EmployeeRecord(String name, int salary, int age) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.id=empcount++;
	}
	@Override
	public int compareTo(EmployeeRecord e) {
		return (this.salary-e.salary);
	}
	public static Comparator<EmployeeRecord> SalaryComparator = new Comparator<EmployeeRecord>() {
		@Override
		public int compare(EmployeeRecord  e1, EmployeeRecord e2) {
			return(e2.salary - e1.salary);
		}
	};
	public static Comparator<EmployeeRecord> AgeComparator = new Comparator<EmployeeRecord>() {
		@Override
		public int compare(EmployeeRecord e1, EmployeeRecord e2) {
			return (e1.age-e2.age);
		}
	};
	public static void printEmployeeList(ArrayList<EmployeeRecord> arr, String Title) {
		System.out.println(Title);		
		int i=0;
		while(i<arr.size()) {
			EmployeeRecord emp = arr.get(i++);
			System.out.println("id:"+emp.id+"  name:"+ emp.name +"  age:"+ emp.age+"  salary:"+emp.salary);
		}

	}
	public static Comparator<EmployeeRecord> AgeSalaryComparator= new Comparator<EmployeeRecord>() {
		@Override
		public int compare(EmployeeRecord e1, EmployeeRecord e2) {
			int flag = e1.salary-e2.salary;
			if(flag == 0) return e1.age-e2.age;
			return flag;
		}
		
	};
	
public static void main(String[] args) {
	Random r = new Random();
	ArrayList<EmployeeRecord> arr = new ArrayList<EmployeeRecord>();
	for(int i=0;i<5;i++) {
		int age = r.nextInt(50);
		EmployeeRecord emp = new EmployeeRecord("Emp"+i,r.nextInt(1000),age <25 ? 25+r.nextInt(10):age);
		arr.add(emp);
	}
	//int i=1;
	//EmployeeRecord emp1 = arr.get(0);
	
	/*while(i<arr.size()) {
		EmployeeRecord emp = arr.get(i++);
		if(emp.compareTo(emp1) > 0) {System.out.println("more salary");};
		System.out.println("id:"+emp.id+"  name:"+ emp.name +"  age:"+ emp.age+"  salary:"+emp.salary);
		emp1 = emp;
	}*/
	
	String Title = "Sort Employee based on Salary Descending";
	Collections.sort(arr,EmployeeRecord.SalaryComparator);
	EmployeeRecord.printEmployeeList(arr, Title);

	Title = "Sort Employee based on Age ascending";	
	Collections.sort(arr,EmployeeRecord.AgeComparator);
	EmployeeRecord.printEmployeeList(arr, Title);

	Title = "Sort Employee based on Age and Salary";	
	Collections.sort(arr,EmployeeRecord.AgeSalaryComparator);
	EmployeeRecord.printEmployeeList(arr, Title);

}
}
