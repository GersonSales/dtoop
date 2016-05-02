package dtoop;

public enum Permission {

	DELETE_EMPLOYEE;

	@Override
	public String toString() {
		switch (this) {
		case DELETE_EMPLOYEE:
			return "Delete employee";
		default:
			return "None";
		}
	}

}
