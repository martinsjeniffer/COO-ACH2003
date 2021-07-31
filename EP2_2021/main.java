import java.util.*;
import java.time.*;

public class main{
  public static void main(String [] args){ 
   ArrayList<Participante> listaDeParticipantes = new ArrayList<Participante>();

    String emailTeste = "janedoe@gmail.com";
    String emailTeste2 = "janedoe2222@gmail.com";

    LocalDateTime inicio = LocalDateTime.of(2021,07,25,15,10,05);
    LocalDateTime fim = LocalDateTime.of(2021,07,25,16,10,05);

    LocalDate inicioReuniao = LocalDate.of(2021,07,30);
    LocalDate fimReuniao = LocalDate.of(2021,07,31);

    Participante janeDoe = new Participante(emailTeste, inicio, fim);
    System.out.println(janeDoe.getEmail() + " " + janeDoe.getInicio() + " " + janeDoe.getFim());

    listaDeParticipantes.add(janeDoe);
    // listaDeParticipantes.add(emailTeste2);
  
    System.out.println("Participantes: " + listaDeParticipantes);


    String nomeSala = "reuniao teste";
    int capacidadeMaxima = 10;
    String descricaoSala = "descricao de teste";

    Reuniao reuniaoteste = new Reuniao(listaDeParticipantes, inicioReuniao, fimReuniao);

    MarcadorDeReuniao teste = new MarcadorDeReuniao(reuniaoteste);
    teste.indicaDisponibilidadeDe("janedoe@gmail.com", LocalDateTime.of(2018,07,23,15,10,05), LocalDateTime.of(2018,07,23,16,10,05));
  }
}
