import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Reserva {
  private LocalDateTime dataInicial;
  private LocalDateTime dataFinal;
  private Sala sala;
  private ArrayList<Participante> Participantes;

  DateTimeFormatter padraoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public Reserva(Sala sala, LocalDateTime dataInicial, LocalDateTime dataFinal) {
    this.dataInicial = dataInicial;
    this.dataFinal = dataFinal;
    this.sala = sala;
  }

  public Sala sala() {
    return sala;
  }

  public LocalDateTime getDataInicial() {
    return this.dataInicial;
  }

  public LocalDateTime getDataFinal() {
    return this.dataFinal;
  }

  public ArrayList<Participante> getParticipantes(){
    return this.Participantes;
  }

  public void imprimeReserva() {
    System.out.println("---------------------------------------------");
    System.out.println(this.sala.getNome());
    System.out.println("Capacidade máxima da sala: " + this.sala.getCapacidade() + " participantes.");
    System.out.println("Horário: " + this.dataInicial.format(padraoData) + " - " + this.dataFinal.format(padraoData));
    System.out.println("---------------------------------------------");
  }
}