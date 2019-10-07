package employees;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.testng.Assert;

public class emptest {
	private ArrayList<EmployeeRecord> arr = new ArrayList<EmployeeRecord>();
	@DataProvider(name="testData")
	public Object[][] testDataMethod(){
		return new Object[][]{{"emp1",41}
							,{"emp2",32}};
	}
	@BeforeClass
	public void setup() {
		Random r = new Random();
		for(int i=0;i<5;i++) {
			int age = r.nextInt(50);
			EmployeeRecord emp = new EmployeeRecord("Emp"+i,r.nextInt(1000),age <25 ? 25+r.nextInt(10):age);
			arr.add(emp);
		}

	}
	@Test(timeOut=500,dependsOnGroups={"group1"})
	public void testSalarySort() {
		String Title = "Sort Employee based on Salary Descending";
		Collections.sort(arr,EmployeeRecord.SalaryComparator);
		EmployeeRecord.printEmployeeList(arr, Title);
		Assert.assertTrue(arr.get(0).salary > arr.get(arr.size()-1).salary);
	}
	@Test(timeOut=500, enabled=true)
	public void testAgeSort() {
		String title = "Sort based on Age";
		Collections.sort(arr,EmployeeRecord.AgeComparator);
		EmployeeRecord.printEmployeeList(arr, title);
		Assert.assertTrue(arr.get(0).age < arr.get(arr.size()-1).age);
	}
	@Test(groups= {"group1"}, dataProvider="testData")
	public void testNothing(String name, int age) {
		System.out.println("**testNothing"+name+age);
	}
	@Test(groups= {"group1"},dependsOnMethods= {"testNothing"})
	public void sometest1() {
		System.out.println("&&sometest1");
	}
}
