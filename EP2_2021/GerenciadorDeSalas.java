import java.time.LocalDateTime;
import java.util.*;

public class GerenciadorDeSalas {
  private List<Sala> salas = new ArrayList<Sala>();
  private Collection<Reserva> reservas = new ArrayList<Reserva>();

  public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao) {
    if (reservasParaSala(nome).size() == 0) {
      Sala novaSala = new Sala(nome, capacidadeMaxima,  descricao);
      this.salas.add(novaSala);
    } else {
      System.out.println("Já existe uma reserva para a sala '" + nome + "'.\n");
    }
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
        System.out.println(">> RESERVA DA SALA '" + nomeDaSala + "' EXECUTADA COM SUCESSO!");
        break;
      }
    }
    
    if (novaReserva == null) {
      System.out.println("ERRO em [reservaSalaChamada()]:");
      System.out.println("Para reservar uma sala primeiro é necessário instanciá-la pelo método adicionaSalaChamada()\n");
    }

    return novaReserva;
  }

  public void cancelaReserva(Reserva cancelada) {
    this.reservas.remove(cancelada);
  }

  public Collection<Reserva> reservasParaSala(String nomeSala) {
    Collection<Reserva> listaDeReservas = new ArrayList<Reserva>();

    for (Reserva r : this.reservas) {
      if (r.sala().getNome().equals(nomeSala)) {
        listaDeReservas.add(r);
      }
    }

    return listaDeReservas;
  }

  public void imprimeReservasDaSala(String nomeSala) {
    Collection<Reserva> listaReservasParaSala = this.reservasParaSala(nomeSala);

    if (listaReservasParaSala.size() == 0) {
      System.out.println ("ERRO em [imprimeReservasDaSala()]: \nA sala '" + nomeSala + "' não possui reservas.\n");
      return;
    }

    for (Reserva reserva : listaReservasParaSala) {
      reserva.imprimeReserva();
    }
  }
}