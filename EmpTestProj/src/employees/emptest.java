package employees;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.testng.Assert;

public class emptest {
	private ArrayList<EmployeeRecord> arr = new ArrayList<EmployeeRecord>();

	@BeforeClass
	public void setup() {
		Random r = new Random();
		for(int i=0;i<5;i++) {
			int age = r.nextInt(50);
			EmployeeRecord emp = new EmployeeRecord("Emp"+i,r.nextInt(1000),age <25 ? 25+r.nextInt(10):age);
			arr.add(emp);
		}

	}
	@Test
	public void testSalarySort() {
		String Title = "Sort Employee based on Salary Descending";
		Collections.sort(arr,EmployeeRecord.SalaryComparator);
		EmployeeRecord.printEmployeeList(arr, Title);
		Assert.assertTrue(arr.get(0).salary > arr.get(arr.size()-1).salary);
	}
}
