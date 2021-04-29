class Stack {
	int [] values;
	int free;

	Stack() {
    values = new int[100];
		free = 0;
	}

	// nao precisamos passar a PILHA por parametro,
	// uma vez que estamos dentro do objeto PILHA então está implícito que o método tem acesso a ele.
	void push(int value) {
		values[free] = value;
		free++;
	}
	
	int pop() {
		free--;
		return values[free];
	}
	
	int empty() {
		return free == 0;
	}
}

/*
 * Escrever um programa que leia uma sequência
 * de valores inteiros e os imprima na ordem
 * inversa à ordem de leitura.
 */
public class Ex4 {
	public static void main(String [] args) {
		Stack stack = new Stack(); 
		int value;
		
		while (/* value = ... */ && value > 0) {
			stack.push(value);
		}
		
		printf("Conteudo em ordem inversa");
		
		while (!stack.empty()) {
			value = stack.pop();
			printf(" %d", value);
		}
	}
}