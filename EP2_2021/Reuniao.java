import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reuniao {
  private ArrayList<Participante> listaParticipantes;
  private ArrayList<Disponibilidade> listaInterseccoes;
  private LocalDate inicioIntervalo;
  private LocalDate finalIntervalo;

  public Reuniao(ArrayList<Participante> participantes, LocalDate inicio, LocalDate fim) {
    this.listaParticipantes = participantes;
    this.inicioIntervalo = inicio;
    this.finalIntervalo = fim;
    this.listaInterseccoes = new ArrayList<>();
  }

  public ArrayList<Participante> getParticipantes() {
    return this.listaParticipantes;
  }

  public LocalDate getInicio() {
    return this.inicioIntervalo;
  }

  public LocalDate getFim() {
    return this.finalIntervalo;
  }

  public ArrayList<Disponibilidade> getInterseccoes() {
    return this.listaInterseccoes;
  }

  public void setParticipantes(ArrayList<Participante> participantes) {
    this.listaParticipantes = participantes;
  }

  public void setInicioIntervalo(LocalDate inicioIntervalo) {
    this.inicioIntervalo = inicioIntervalo;
  }

  public void setFinalIntervalo(LocalDate finalIntervalo) {
    this.finalIntervalo = finalIntervalo;
  }

  private boolean disponibilidadeValida(Disponibilidade disponibilidade, LocalDateTime inicio, LocalDateTime fim) {
    return disponibilidade.getInicio().isBefore(fim) && disponibilidade.getFim().isAfter(inicio);
  }

  void defineInterseccoes(int index, LocalDateTime inicio, LocalDateTime fim) {
    Participante participante;
    ArrayList<Disponibilidade> listaIntervalos;
    LocalDateTime inicioPadrao, fimPadrao;

    inicioPadrao = inicio;
    fimPadrao = fim;

    participante = listaParticipantes.get(index);
    listaIntervalos = participante.getDisponibilidade();

    for (Disponibilidade disponibilidade : listaIntervalos) {
      if (disponibilidadeValida(disponibilidade, inicio, fim)) {
        if (disponibilidade.getFim().isBefore(fim)) {
          fim = disponibilidade.getFim();
        }

        if (disponibilidade.getInicio().isAfter(inicio)) {
          inicio = disponibilidade.getInicio();
        }

        if (listaParticipantes.size() - 1 != index) {
          defineInterseccoes(index + 1, inicio, fim);
        } else {
          listaInterseccoes.add(new Disponibilidade(inicio, fim));
        }
      }

      inicio = inicioPadrao;
      fim = fimPadrao;
    }
  }
}
