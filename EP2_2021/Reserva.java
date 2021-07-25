import java.time.*;

public class Reserva{
  private String nomeDaSala;
  private LocalDateTime dataInicial;
  private LocalDateTime dataFinal;

  public Reserva(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {
    this.nomeDaSala = nomeDaSala;
    this.dataInicial = dataInicial;
    this.dataFinal = dataFinal;
  }

  public String getNomeDaSala() {
    return this.nomeDaSala;
  }

  public LocalDateTime getDataInicial() {
    return this.dataInicial;
  }

  public LocalDateTime getDataFinal() {
    return this.dataFinal;
  }
}