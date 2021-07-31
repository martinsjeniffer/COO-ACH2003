import java.time.LocalDateTime;
import java.util.*;

public class GerenciadorDeSalas {
  private List<Sala> salas = new ArrayList<Sala>();
  private Collection<Reserva> reservas = new ArrayList<Reserva>();

  public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao) {
    Sala novaSala = new Sala(nome, capacidadeMaxima,  descricao);
    this.salas.add(novaSala);
  }

  public void removeSalaChamada(String nomeDaSala) {
    for (Sala sala : this.salas) {
      if (nomeDaSala.equals(sala.getNome())) {
        this.salas.remove(sala);
        return;
      }
    }
  }

  public List<Sala> listaDeSalas() {
    return this.salas;
  }

  public void adicionaSala(Sala novaSala) {
    this.salas.add(novaSala); 
  }

  public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {
    Reserva novaReserva = null;

    for (Sala sala : listaDeSalas()) {
      if (sala.getNome().equals(nomeDaSala)){
        novaReserva = new Reserva(sala, dataInicial, dataFinal);
        this.reservas.add(novaReserva);
      }
      break;
    }

    return novaReserva;
  }

  public void cancelaReserva(Reserva cancelada) {
    this.reservas.remove(cancelada);
  }

  public Collection<Reserva> reservasParaSala(String nomeSala) {
    return this.reservas;
  }

  public void imprimeReservasDaSala(String nomeSala) {
    int i = 0;

    for (Reserva reserva : this.reservas) {
      if (reserva.sala().getNome() == nomeSala) {
        reserva.imprimeReserva();
        i++;
      }
    }

    if (i == 0) {
      System.out.println ("\nEsta sala não possui reservas.\n");
    }
  }
}