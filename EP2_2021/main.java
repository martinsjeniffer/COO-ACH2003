import java.time.*;
import java.util.*;

public class main {

  // public static void main(String[] args) {
  //   Collection<String> listaDeParticipantes = new ArrayList<String>();

  //   String emailTeste = "janedoe@gmail.com";
  //   String emailTeste2 = "janedoe2222@gmail.com";

  //   LocalDateTime dispParticipanteInicio = LocalDateTime.of(2021, 07, 25, 15, 10, 05);
  //   LocalDateTime dispParticipanteFim = LocalDateTime.of(2021, 07, 25, 16, 10, 05);

  //   LocalDate inicioReuniao = LocalDate.of(2021, 07, 25);
  //   LocalDate fimReuniao = LocalDate.of(2021, 07, 25);

  //   Participante janeDoe = new Participante(emailTeste, dispParticipanteInicio, dispParticipanteFim);
  //   Participante janeDoe2222 = new Participante(emailTeste2, dispParticipanteInicio, dispParticipanteFim);
  //   System.out.println(
  //     janeDoe.getEmail() + " " + janeDoe.getInicio() + " " + janeDoe.getFim()
  //   );

  //   listaDeParticipantes.add(emailTeste);
  //   listaDeParticipantes.add(emailTeste2);

  //   System.out.println("Participantes: " + listaDeParticipantes);

  //   String nomeSala = "reuniao teste";
  //   int capacidadeMaxima = 10;
  //   String descricaoSala = "descricao de teste";

  //   MarcadorDeReuniao teste = new MarcadorDeReuniao();

  //   teste.marcarReuniaoEntre(inicioReuniao, fimReuniao, listaDeParticipantes);
  //   teste.indicaDisponibilidadeDe(
  //     emailTeste,
  //     dispParticipanteInicio,
  //     dispParticipanteFim
  //   );

  //   teste.indicaDisponibilidadeDe(
  //     emailTeste2,
  //     dispParticipanteInicio,
  //     dispParticipanteFim
  //   );

  //   teste.mostraSobreposicao();
  // }

  public static void main(String[] args) {
    //Código teste para entender o fluxo de dados do programa
    
    Collection<String> participantes = new ArrayList<String>();
    
    participantes.add("Paulo");
    participantes.add("Pedro");
    participantes.add("Ale");
    
    MarcadorDeReuniao marcador = new MarcadorDeReuniao();
    marcador.marcarReuniaoEntre(LocalDate.parse("2019-01-01"), LocalDate.parse("2019-01-10"), participantes);
    
    marcador.indicaDisponibilidadeDe("Paulo", LocalDateTime.parse("2019-01-01T08:30"), LocalDateTime.parse("2019-01-01T10:00"));
    marcador.indicaDisponibilidadeDe("Paulo", LocalDateTime.parse("2019-01-01T16:00"), LocalDateTime.parse("2019-01-01T18:00"));
    marcador.indicaDisponibilidadeDe("Paulo", LocalDateTime.parse("2019-01-03T12:00"), LocalDateTime.parse("2019-01-03T16:00"));
    marcador.indicaDisponibilidadeDe("Pedro", LocalDateTime.parse("2019-01-01T09:00"), LocalDateTime.parse("2019-01-01T17:00"));
    marcador.indicaDisponibilidadeDe("Pedro", LocalDateTime.parse("2019-01-03T11:00"), LocalDateTime.parse("2019-01-03T13:00"));
    marcador.indicaDisponibilidadeDe("Pedro", LocalDateTime.parse("2019-01-03T15:00"), LocalDateTime.parse("2019-01-03T17:00"));
    marcador.indicaDisponibilidadeDe("Ale", LocalDateTime.parse("2019-01-02T01:00"), LocalDateTime.parse("2019-01-02T23:00"));
    marcador.indicaDisponibilidadeDe("Ale", LocalDateTime.parse("2019-01-01T09:30"), LocalDateTime.parse("2019-01-01T16:30"));
    marcador.indicaDisponibilidadeDe("Ale", LocalDateTime.parse("2019-01-03T12:30"), LocalDateTime.parse("2019-01-03T15:30"));
    

    marcador.novaReuniao.mostraSobreposicao();
  }
}
