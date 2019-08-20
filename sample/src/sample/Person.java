package sample;

public class Person {
	
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
