import java.time.*;

public class Participante{
  private String email;
  private LocalDateTime inicio, fim;

  public Participante(String email, LocalDateTime inicio, LocalDateTime fim) {
    this.email = email;
    this.inicio = inicio;
    this.fim = fim;
  }

  public String getEmail() {
    return this.email;
  }

  public LocalDateTime getInicio() {
    return this.inicio;
  }

  public LocalDateTime getFim() {
    return this.fim;
  }
}