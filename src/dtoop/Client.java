package dtoop;

public class Client {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		 Employee firstEmployee = new Employee("First Employee", 21);
		 Employee secondEmployee = new Employee("Second Employee", 52);
		
		 System.out.println(firstEmployee);
		 System.out.println(secondEmployee);
		
		 System.out.println(firstEmployee.permissionsToString());
		
		 firstEmployee.addPermission(Permission.DELETE_EMPLOYEE);
		
		 System.out.println(firstEmployee.permissionsToString());

	}

}