import java.time.*;
import java.util.*;

public class MarcadorDeReuniao {
  Reuniao novaReuniao;

  public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
    ArrayList<Participante> participantes = new ArrayList<Participante>();

    for (String pessoa : listaDeParticipantes) {
      participantes.add(new Participante(pessoa));
    }

    novaReuniao = new Reuniao(participantes, dataInicial, dataFinal);
  }

  public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim) {
    LocalDateTime inicioReuniao, fimReuniao;

    if (inicio.isAfter(fim)) {
      System.out.println("ERRO: Período de inicio da disponibilidade deve ser antes do final.");
      return;
    }

    inicioReuniao = this.novaReuniao.getInicio().atStartOfDay();
    fimReuniao    = this.novaReuniao.getFim().atTime(23, 59, 59);

    if (inicio.isBefore(inicioReuniao) || fim.isAfter(fimReuniao)) {
      System.out.println("ERRO: O horário indicado de disponibilidade não está dentro do intervalo possível para a reunião.");
      return;
    }

    ArrayList<Participante> listaParticipantes = novaReuniao.getParticipantes();
    Participante participanteInformado = null;

    for (Participante pessoa : listaParticipantes) {
      if (pessoa.getEmail().equals(participante)) {
        participanteInformado = pessoa;
        break;
      }
    }

    if (participanteInformado != null) {
      participanteInformado.setDisponibilidade(inicio, fim);
      return;
    }

    System.out.println("ERRO: Pessoa informada não faz parte da lista de participantes");
  }

  public void mostraSobreposicao() {
    ArrayList<Disponibilidade> dispParticipante;
    ArrayList<Participante> listaParticipantes;
    ArrayList<Disponibilidade> listaInterseccoes;
    LocalDateTime inicioDisp, fimDisp;

    listaParticipantes = novaReuniao.getParticipantes();
    
    for (Participante pessoa : listaParticipantes) {
      dispParticipante = pessoa.getDisponibilidade();

      System.out.println("---------------------------------------------");
      System.out.println(pessoa.getEmail());
      System.out.println("\nPeríodos disponíveis:");
      if (dispParticipante != null) {
        for (Disponibilidade disponibilidade : dispParticipante) {
          disponibilidade.imprimeDisponibilidade();
        }
      }
      System.out.println("----------------------------------------------\n");
    }

    inicioDisp = novaReuniao.getInicio().atStartOfDay();
    fimDisp = novaReuniao.getFim().atTime(23, 59, 59);

    novaReuniao.defineInterseccoes(0, inicioDisp, fimDisp);
    listaInterseccoes = novaReuniao.getInterseccoes();

    if (listaInterseccoes != null) {
      System.out.println("HORÁRIOS DISPONÍVEIS PARA TODES: ");
      for (Disponibilidade interseccao : listaInterseccoes) {
        interseccao.imprimeDisponibilidade();
      }
      System.out.println("");
      return;
    }

    System.out.println("Infelizmente não existem horários compatíveis para todos os participantes.");
  }
}
