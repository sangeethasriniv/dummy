package employees;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.io.*;

public class RESTTest {
	public static void main (String[] args) throws Exception{
		URL u = new URL("http://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		System.out.println(conn.getResponseCode());
		Scanner sc = new Scanner(u.openStream());
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
		File f = new File(System.getProperty("user.dir")+"/a.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		while(br.readLine()!=null) {
			System.out.println(br.readLine());
		}
	}
}
