package employees;

public class Singleton {
	private static Singleton instance = null;
	private String s;
	private Singleton() {
		s="I am a singleton";
	}
	public static Singleton getInstance() {
		if(instance == null) 
			instance = new Singleton();
		return instance;
	}
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.s);
	}
}
