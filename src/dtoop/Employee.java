package dtoop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Person{

	private List<Permission> permissions;

	public Employee(String name, Integer age) {
		super(name, age);
		
		this.permissions = new ArrayList<>();
	}

	public void addPermission(Permission permission) {
		this.permissions.add(permission);
	}

	public String permissionsToString() {
		StringBuffer st = new StringBuffer();
		permissions.forEach(per -> st.append(per));
		return st.toString();
	}

	@Override
	public String toString() {
		return "Name: " + getName() + " Age: " + getAge();
	}

}
