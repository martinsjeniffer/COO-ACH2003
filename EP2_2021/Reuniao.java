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

  void defineInterseccoes(int index, LocalDateTime inicio, LocalDateTime fim) {
    Participante participante = listaParticipantes.get(index);
    ArrayList<Disponibilidade> listaIntervalos = participante.getDisponibilidade();
    LocalDateTime inicioPadrao = inicio;
    LocalDateTime fimPadrao = fim;

    for (Disponibilidade inicioAtual : listaIntervalos) {
      if (
        inicioAtual.getInicio().isBefore(fim) &&
        inicioAtual.getFim().isAfter(inicio)
      ) {
        if (inicioAtual.getFim().isBefore(fim)) fim = inicioAtual.getFim();

        if (inicioAtual.getInicio().isAfter(inicio)) inicio =
          inicioAtual.getInicio();

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
