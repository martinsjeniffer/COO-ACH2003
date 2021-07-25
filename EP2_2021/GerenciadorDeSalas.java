import java.time.LocalDateTime;
import java.util.*;

public class GerenciadorDeSalas {
  /* que deve receber o nome da sala, a capacidade máxima da sala, e uma descrição;*/
  public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao) {

  }
  
  /*que deve receber  o nome da sala a ser removida;*/
  public void removeSalaChamada(String nomeDaSala) {

  }

  /*que deve devolver uma instância de List com objetos do tipo Sala; */
  public List<Sala> listaDeSalas() {
    return null;
  }

  /*que deve receber uma instância de Sala;*/
  public void adicionaSala(Sala novaSala) {

  }

  /* que recebe um nome de sala, um LocalDateTime que indica o início da reserva e um outro LocalDateTime para indicar o final da reserva. O método deve devolver uma instância de Reserva;*/
  public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) {
    return null;
  }

  
  /*que recebe um objeto do tipo Reserva e cancela esta reserva;*/
  public void cancelaReserva(Reserva cancelada) {

  }

  /*que devolve uma Collection de objetos Reserva que representam as reservas da 
 respectiva sala.*/
  public Collection<Reserva> reservasParaSala(String nomeSala) {
    return null;
  }
  
  /*que recebe uma String com o nome da sala e imprime todas as suas reservas */
  public void imprimeReservasDaSala(String nomeSala) {

  }
}