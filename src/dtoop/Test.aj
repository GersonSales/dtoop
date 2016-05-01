package dtoop;

public aspect Test {

	private pointcut noSet() : call (void Person+.set*(..));
	
	void around() : noSet() {
		throw new IllegalAccessError("Acces denied!");
	}
	
	private pointcut toString() : call (String *.toString());

	String around() : toString() {
		String newToString = proceed();
		return newToString.toLowerCase();
	}

	private pointcut getAge() : call (Integer *.getAge());

	Integer around() : getAge() {
		return 45;
	}

	private pointcut getName() : call (String *.getName());

	String around() : getName() {
		return "NAME";
	}

}
