import java.util.*;
import java.time.*;

public class MarcadorDeReuniao{
  public static void main(String[] args) {
    Collection<String> listaDeParticipantes = new ArrayList();

    listaDeParticipantes.add("janedoe@gmail.com");

    System.out.println("Participantes:" + listaDeParticipantes);

    Participante janeDoe = new Participante("janedoe@gmail.com", LocalDateTime.of(2021,07,25,15,10,05), LocalDateTime.of(2021,07,25,16,10,05));

    LocalDateTime data = janeDoe.getInicio();


    System.out.println(data);
    System.out.println(janeDoe.getEmail());
    
    indicaDisponibilidadeDe("janedoe@gmail.com", LocalDateTime.of(2018,07,23,15,10,05), LocalDateTime.of(2018,07,23,16,10,05));
  }

  public void indicaDisponibilidadeDe(String participante,LocalDateTime inicio,LocalDateTime fim){

  }

	public void marcarReuniaoEntre(LocalDate dataInicial,LocalDate dataFinal,Collection<String> listaDeParticipantes){
	}

	public void mostraSobreposicao(){
	}
}