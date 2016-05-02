package dtoop;

import java.util.ArrayList;

public aspect Test {
	private static Integer idEmployee = 1;

	private Integer Employee.idNumber;

	public Integer Employee.getIdNumber() {
		return this.idNumber;
	}

	declare error : call (ArrayList.new(..)) :"It is not allowed to use ArrayList";

	before() : call(ArrayList.new(..)) {
		try {
			throw new IllegalAccessError("It is not allowed to use ArrayList");
		} catch (IllegalAccessError erro) {
			erro.printStackTrace(System.out);
			System.exit(0);
		}
	}

	private pointcut newInstanceEmployee(Employee employee) : execution(Employee.new(..)) && this(employee);

	after(Employee employee) : newInstanceEmployee(employee) {
		employee.idNumber = idEmployee;
		idEmployee++;
	}

	private pointcut toStringPlusId(Employee employee) : execution(String Employee.toString()) && this(employee);

	String around(Employee employee) : toStringPlusId(employee)  {
		String toStringWithId = proceed(employee);
		return toStringWithId.concat(" ID: " + employee.getIdNumber());
	}

	private pointcut addPermission(Employee employee, Permission permission) : 
		execution (void Employee.addPermission(Permission)) && target(employee) && args(permission);

	before(Employee employee, Permission permission) : addPermission(employee, permission) {
		System.out.println("The permission '" + permission + "' was added to " + employee.getName() + ".");
	}

	private pointcut zpermissionsToString() : execution (String Employee.permissionsToString());

	String around(): zpermissionsToString() {
		String permissions = proceed();
		return permissions.equals("") ? "No permissions!" : permissions;
	}

}
