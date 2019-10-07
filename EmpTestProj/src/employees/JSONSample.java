package employees;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.util.*;
public class JSONSample {
	public static void main(String[] args)throws Exception {
		/*Scanner s = new Scanner(System.in);
		String temp = "{\n";
		String inp = s.nextLine();
		while(!inp.equals("end")) {			
			temp = temp+"\t"+inp+"\n";
			inp = s.nextLine();
			
		}
		temp=temp+"}";*/
		String temp = "{"
				+ "\"name\""+":"+"\"sangeetha\""
				+ " \"age\""+":"+"41"
				+ " \"roles\""+":"+"[\"qa\", \"dev\"]"
				+"}";
		
		System.out.println(temp);
		JSONParser jp = new JSONParser();
		JSONObject jobj = (JSONObject)jp.parse(temp);
		String name =(String)jobj.get("name");
		System.out.println(jobj.get("age"));
		JSONArray jarr = (JSONArray)jobj.get("roles");
		Iterator it = jarr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		int i=0;
		while(i<jarr.size())
		{
			System.out.println(jarr.get(i));
			i++;
		}
	}
	
	
}
