import java.util.*;

class Stack {
  /* 
    nem se colocassemos um private aqui resolveria 
    a questao de acesso as informacoes.
    pq ai os metodos de inicializacao nao iam ter 
    acesso a esses atributos e ia ferrar o funcionamento
  */
  int [] values;
  int free;
}

/*
 * Escrever um programa que leia uma sequência
 * de valores inteiros e os imprima na ordem
 * inversa à ordem de leitura.
 */
public class Ex3b {
  static void init(Stack stack) {
    stack.values = new int[100]; 
    stack.free = 0;
  }

  static void push(Stack stack, int value) {
    stack.values[stack.free] = value;
    stack.free++;
  }

  static int pop(Stack stack) {
    stack.free--;
    return stack.values[stack.free];
  }

  static boolean empty(Stack stack) {
    return stack.free == 0;
  }

  public static void main(String [] args) {
    Stack stack = new Stack();
    int value;

    Scanner scanner = new Scanner(System.in);

    init(stack);

    while ((value = scanner.nextInt()) && value > 0) {
      push(stack, value);
    }

    System.out.println("Conteudo em ordem inversa");

    while (!empty(stack)) {
      value = pop(stack);
      System.out.println(" %d", value);
    }
  }
}