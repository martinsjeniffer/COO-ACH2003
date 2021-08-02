import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Disponibilidade {
  private LocalDateTime inicio;
  private LocalDateTime fim;

  DateTimeFormatter padraoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public Disponibilidade(LocalDateTime inicio, LocalDateTime fim) {
    this.inicio = inicio;
    this.fim = fim;
  }

  public LocalDateTime getInicio() {
    return this.inicio;
  }

  public LocalDateTime getFim() {
    return this.fim;
  }

  public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
  }

  public void setFim(LocalDateTime fim) {
    this.fim = fim;
  }

  public void imprimeDisponibilidade() {
    System.out.println(
      "De " + this.inicio.format(padraoData) + " até " + this.fim.format(padraoData)
    );
  }
}
