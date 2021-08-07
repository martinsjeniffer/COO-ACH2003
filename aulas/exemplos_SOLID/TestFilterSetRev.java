import java.util.*;

// Versão revisada em que o princípio aberto/fechado é respeitado.
// Também podemos verificar neste exemplo o princípio da inversão
// de dependencias.

interface Criterio {

	public boolean seleciona(int x);
}

class Todos implements Criterio {

	public boolean seleciona(int x){ return true; }
}

class Pares implements Criterio {

	public boolean seleciona(int x){ return x % 2 == 0; }
}

class Impares implements Criterio {

	public boolean seleciona(int x){ return x % 2 == 1; }
}

class MenoresQue implements Criterio {

	private int k;

	public MenoresQue(int k) { this.k = k; }

	public boolean seleciona(int x){ return x < k; }
}

class MaioresQue implements Criterio {

	private int k;

	public MaioresQue(int k) { this.k = k; }

	public boolean seleciona(int x){ return x > k; }
}

class Entre implements Criterio {

	private int min, max;

	public Entre(int min, int max) { this.min = min; this.max = max; }

	public boolean seleciona(int x){ return x > min && x < max; }
}	

class FilterSet {

	private Collection<Integer> col;

	// Se uma instancia de FilterSet mantivesse uma referencia
	// para um tipo concreto de criterio, teriamos uma violação
	// do princípio da inversão de dependencia.
	
	//private Entre criterio;	//	FilterSet ----> Entre


	// Ao manter uma referencia para um Criterio, invertemos
	// o sentido da dependencia entre FilterSet e a classe que
	// efetivamente implementa o critério.
	
	private Criterio criterio;	//  	FilterSet ----> Criterio <------ Entre
				   	// 		           ^------------ MaioresQue			

	public FilterSet(Criterio crit){

		col = new TreeSet<>();
		criterio = crit;
	}

	public void adiciona(int x){

		if(criterio.seleciona(x)) col.add(x);
	}

	public String toString(){

		return col.toString();
	}
}

public class TestFilterSetRev {

	public static void teste(Criterio crit){

		FilterSet set = new FilterSet(crit);

		for(int i = 0; i < 16; i++) set.adiciona(i);

		System.out.println(set);
		System.out.println("----------------------------------------------------------------");
	}

	public static void main(String [] args){

		teste(new Todos());
		teste(new Pares());
		teste(new Impares());
		teste(new MenoresQue(10));
		teste(new MaioresQue(5));
		teste(new Entre(5, 10));
	}
}


