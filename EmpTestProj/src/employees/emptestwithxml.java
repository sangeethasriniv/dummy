package employees;
import org.testng.annotations.*;
public class emptestwithxml {
	@Test
	@Parameters({"empname"})
	public void testOne(String empname) {
		System.out.println(empname);
	}
}
