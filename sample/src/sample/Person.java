package sample;

public class Person {
	public static final String GENER_MALE = "1";
	public static final String GENER_FEMALE = "2";
	
	private String name;
	private String birth;
	
	public Person() {
		
	}
	
	public Person(String name, String birth) {
		this.name = name;
		this.birth = birth;
	}
	
	public void intro(String message) {
		System.out.println(message + " " + name);
	}

}
