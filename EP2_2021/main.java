import java.time.*;
import java.util.*;

public class main {
  public static void main(String[] args) {
    Collection<String> participantes = new ArrayList<String>();
    GerenciadorDeSalas gerenciaSalas = new GerenciadorDeSalas();

    String paulo = "paulo@gmail.com";
    String joana = "joana@outlook.com";
    String camila = "camila@gmail.com";

    participantes.add(paulo);
    participantes.add(joana);
    participantes.add(camila);

    MarcadorDeReuniao marcador = new MarcadorDeReuniao();
    marcador.marcarReuniaoEntre(
      LocalDate.parse("2019-01-01"),
      LocalDate.parse("2019-01-10"),
      participantes
    );

    marcador.indicaDisponibilidadeDe(
      paulo,
      LocalDateTime.parse("2019-01-01T08:30"),
      LocalDateTime.parse("2019-01-01T10:00")
    );
    marcador.indicaDisponibilidadeDe(
      joana,
      LocalDateTime.parse("2019-01-01T09:00"),
      LocalDateTime.parse("2019-01-01T17:00")
    );
    marcador.indicaDisponibilidadeDe(
      joana,
      LocalDateTime.parse("2019-01-03T11:00"),
      LocalDateTime.parse("2019-01-03T13:00")
    );
    marcador.indicaDisponibilidadeDe(
      joana,
      LocalDateTime.parse("2019-01-03T15:00"),
      LocalDateTime.parse("2019-01-03T17:00")
    );
    marcador.indicaDisponibilidadeDe(
      camila,
      LocalDateTime.parse("2019-01-02T01:00"),
      LocalDateTime.parse("2019-01-02T23:00")
    );
    marcador.indicaDisponibilidadeDe(
      camila,
      LocalDateTime.parse("2019-01-01T09:30"),
      LocalDateTime.parse("2019-01-01T16:30")
    );
    marcador.indicaDisponibilidadeDe(
      camila,
      LocalDateTime.parse("2019-01-03T12:30"),
      LocalDateTime.parse("2019-01-03T15:30")
    );

    marcador.mostraSobreposicao();

    String nomeSala = "Reunião sobre EP2 de COO";

    gerenciaSalas.adicionaSalaChamada(nomeSala, 5, "Precisamos iniciar o esqueleto do EP e mapear as classes necessárias para a implementação correta do trabalho.");
    // gerenciaSalas.adicionaSalaChamada(nomeSala, 5, "descricao qualquer");
    // gerenciaSalas.adicionaSalaChamada("sala2", 15, "descricao qualquer2222");

    gerenciaSalas.reservaSalaChamada(
      nomeSala,
      LocalDateTime.parse("2019-01-01T09:30"),
      LocalDateTime.parse("2019-01-01T10:00")
    );
    // gerenciaSalas.reservaSalaChamada(nomeSala, LocalDateTime.parse("2019-01-01T09:30"), LocalDateTime.parse("2019-01-01T10:00"));

    gerenciaSalas.imprimeReservasDaSala(nomeSala);
  }
}
