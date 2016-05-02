package lesson;

public aspect aspecExample {
	
	private pointcut resolver() : call (void ExemploPointcut.resolver(int));
	
	private pointcut construtores() : call (ExemploPointcut.new(..));
	
	private pointcut leituraDeCampo() : get(int ExemploPointcut.dificuldade);
	
	private pointcut escritaDeCampo() : set(* ExemploPointcut.*);

	private pointcut capturaExcecao() : handler(IllegalAccessError);
}
