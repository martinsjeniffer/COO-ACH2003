
// Versão revisada em que o princípio da segregação de interfaces é aplicado.
// Observe como a aplicação deste principio também resolve a violação do
// princípio da substituição de Liskov.

interface Lutador {

	public void atacar(Personagem alvo);
}

interface UsuarioMagia {

	public void usarMagia(Personagem alvo);
}

abstract class Personagem {

	private String nome;

	public Personagem(String nome){

		this.nome = nome;
	}

	public String toString(){

		return nome;
	}
}

class Ranger extends Personagem implements Lutador, UsuarioMagia {

	public Ranger(String nome){

		super(nome);
	}

	public void atacar(Personagem alvo){

		System.out.println(this + " atacando " + alvo);
	}

	public void usarMagia(Personagem alvo){

		System.out.println(this + " usando magia em " + alvo);
	}
}

class Paladino extends Personagem implements Lutador, UsuarioMagia {

	public Paladino(String nome){

		super(nome);
	}

	public void atacar(Personagem alvo){

		System.out.println(this + " atacando " + alvo);
	}

	public void usarMagia(Personagem alvo){

		System.out.println(this + " usando magia em " + alvo);
	}
}


class Mago extends Personagem implements UsuarioMagia{

	public Mago(String nome){

		super(nome);
	}

	public void usarMagia(Personagem alvo){

		System.out.println(this + " usando magia em " + alvo);
	}
}

class Guerreiro extends Personagem implements UsuarioMagia{

	public Guerreiro(String nome){

		super(nome);
	}

	public void atacar(Personagem alvo){

		System.out.println(this + " atacando " + alvo);
	}
}

public class TestePersonagemRev {

	public static void main(String [] args){

		// ...
	}
}
