package lesson;

public class ExemploPointcut {
	String titulo;
	int dificuldade;

	ExemploPointcut() {
		titulo = new String("Exemplo de pointcut");
		dificuldade = 1;
	}

	ExemploPointcut(String s, int diff) {
		titulo = new String(s);
		dificuldade = diff;
	}

	void Resolver(int diff) {
		if (dificuldade == diff) {
			System.out.println("Resolvido!");
		}
	}
}
