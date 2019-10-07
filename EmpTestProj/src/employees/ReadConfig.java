package employees;
import java.util.*;
public class ReadConfig {
	public static void main(String[] args) {
		System.out.println("Current Locale: " + Locale.getDefault());

		ResourceBundle rb = ResourceBundle.getBundle("employees.config");
		System.out.println(rb.getString("name"));
		System.out.println(rb.getString("age"));
		System.out.println(rb.getString("url"));
		
	}

}
