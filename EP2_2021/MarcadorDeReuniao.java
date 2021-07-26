import java.util.*;
import java.time.*;

public class MarcadorDeReuniao{
  Reuniao reuniao;

  public static void main(String[] args) {
    Collection<String> listaDeParticipantes = new ArrayList<String>();

    String emailTeste = "janedoe@gmail.com";
    String emailTeste2 = "janedoe2222@gmail.com";

    LocalDateTime inicio = LocalDateTime.of(2021,07,25,15,10,05);
    LocalDateTime fim = LocalDateTime.of(2021,07,25,16,10,05);

    listaDeParticipantes.add(emailTeste);
    listaDeParticipantes.add(emailTeste2);

    Participante janeDoe = new Participante(emailTeste, inicio, fim);
    System.out.println(janeDoe.getEmail() + " " + janeDoe.getInicio() + " " + janeDoe.getFim());

    System.out.println("Participantes: " + listaDeParticipantes);


    String nomeSala = "reuniao teste";
    int capacidadeMaxima = 10;
    String descricaoSala = "descricao de teste";
    
    // indicaDisponibilidadeDe("janedoe@gmail.com", LocalDateTime.of(2018,07,23,15,10,05), LocalDateTime.of(2018,07,23,16,10,05));
  }


  /*onde cada participante é identificado com uma String e o início e fim da
   de java.time.LocalDateTime.*/
  public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
    /*compara o inicio e o fim da disponibilidade um participante (recbido no argumento) com o inicio e o fim de uma reunião */

    /* verificando a legibilidade reuniao nos horarios passados como argumentos*/
    if(inicio.isAfter(fim)){
      System.out.println("O inicio deve ser antes do final");
      return;
    }
       
    LocalDateTime inicioReuniao= reuniao.getInicioIntervalo().atStartOfDay();    LocalDateTime fimReuniao = reuniao.getFinalIntervalo().atTime(23,59,59);

    if(!((inicio.isAfter(inicioReuniao) || inicio.isEqual(inicioReuniao))
    && (fim.isBefore(fimReuniao) || fim.isEqual(fimReuniao)))){
      System.out.println("O horario indicado nao esta no intervalo disponivel para a reuniao");
      return;
    }

    ArrayList<Participante> Participantes = reuniao.getParticipantes();
    Participante participanteInformado = null;

    //procurando o participante recebido no argumento pelo email na lista de Participantes da reunião
    for(Participante part : Participantes){
      if(part.email.equals(participante)){
        //Participante encontrado
        participanteInformado = part;
        break;
      }
    }

    if(participanteSelecionado != null){
      //Participante existe -- Inclui um intervalo disponível dele
      participanteInformado.setDisponibilidade(inicio, fim);
    }else{
      System.out.println("Participante não encontrado na lista da reunião");
    }
  }  

  //A definição dos participantes da reunião
	public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){

    ArrayList<Participante> Participantes = new ArrayList<Participante>();
        
    for(String email : listaDeParticipantes){
      Participantes.add(new Participante(email));
    }

    ReuniaoMarcada = new Reuniao(Participantes, dataInicial, dataFinal);

	}

  /*deve exibir um relatório com as escolhas realizadas e indicar em quais horários todos os participantes
  poderiam participar da reunião.*/
	public void mostraSobreposicao(){
    
	}
}