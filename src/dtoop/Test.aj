package dtoop;

public aspect Test {

	pointcut toString() : call (String *.toString());

	String around() : toString() {
		String newToString = proceed();
		return newToString.toLowerCase();
	}
	
	pointcut getAge() : call (Integer *.getAge());
	
	Integer around() : getAge() {
		return 45;
	}
	
	pointcut getName() : call (String *.getName());
	
	String around() : getName() {
		return "NAME";
	}

}
