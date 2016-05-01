package dtoop;

public aspect Test {
	pointcut t() : within(TestClass.class);
	
	before():  t() {
		System.out.println(thisJoinPoint.getSignature());
	}

}
