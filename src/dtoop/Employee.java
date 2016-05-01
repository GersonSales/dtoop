package dtoop;

public class Employee extends Person {

	public Employee(String name, Integer age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return "MY NAME IS " + getName().toUpperCase() + " AND I AM " + getAge() + " YEARS OLD AND I AM AN EMPLOYEE";
	}

}
