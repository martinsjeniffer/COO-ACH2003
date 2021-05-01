import java.util.*;

class Stack {
  // atributos que cada instancia vai ter
  private int [] values;
  private int free;

  /*
   * construtor na realidade devolve um ENDERECO.
   * por isso nao tem tipo de retorno (nem void)
   */
  public Stack() {
    // analogo ao um malloc em C
    values = new int[100]; 
    free = 0;
  }

  /*
   * nao precisamos passar a PILHA por parametro,
   * uma vez que estamos dentro do objeto PILHA 
   * entao esta implicito que o metodo tem acesso a ele.
   */
  public void push(int value) {
    values[free] = value;
    free++;
  }

  public int pop() {
    free--;
    return values[free];
  }

  public boolean empty() {
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

    System.out.println("Conteudo em ordem inversa");
    
    while (!stack.empty()) {
      value = stack.pop();
      System.out.println(" %d", value);
    }
  }
}