package dtoop;

public class Client {

	public static void main(String[] args) {
		try {
			
		Person gerson = new Employee("Gerson", 21);
		
		System.out.println(gerson);
		
		String string = new String("TESTING THE LOWER CASE");
		
		System.out.println(string);
		
		gerson.setAge(124);
		}catch (IllegalAccessError error){
			System.out.println(error.getMessage() + "<---");
		}

	}

}