import java.util.*;
import java.time.*;

public class MarcadorDeReuniao{
  Reuniao reuniao;

  public MarcadorDeReuniao(Reuniao reuniao) {
    this.reuniao = reuniao;
  }

  /*onde cada participante é identificado com uma String e o início e fim da
   de java.time.LocalDateTime.*/
  public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
    /*compara o inicio e o fim da disponibilidade um participante (recbido no argumento) com o inicio e o fim de uma reunião */
    System.out.println("aaaa");

    /* verificando a legibilidade reuniao nos horarios passados como argumentos*/
    if(inicio.isAfter(fim)){
      System.out.println("O inicio deve ser antes do final");
      return;
    }
    System.out.println("bbbb " + this.reuniao.getInicioIntervalo().atStartOfDay() + this.reuniao.getFinalIntervalo());
       
    LocalDateTime inicioReuniao= this.reuniao.getInicioIntervalo().atStartOfDay();    
    LocalDateTime fimReuniao = this.reuniao.getFinalIntervalo().atTime(23,59,59);

    if(!((inicio.isAfter(inicioReuniao) || inicio.isEqual(inicioReuniao))
    && (fim.isBefore(fimReuniao) || fim.isEqual(fimReuniao)))){
      System.out.println("O horario indicado nao esta no intervalo disponivel para a reuniao");
      return;
    }

    System.out.println("cccc");
    ArrayList<Participante> Participantes = reuniao.getParticipantes();
    Participante participanteInformado = null;

    System.out.println("cccc");
    //procurando o participante recebido no argumento pelo email na lista de Participantes da reunião
    for(Participante part : Participantes){
      if(part.getEmail().equals(participante)){
        //Participante encontrado
        participanteInformado = part;
        break;
      }
    }
    System.out.println("444444");

    if(participanteInformado != null){
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
    Reuniao ReuniaoMarcada = new Reuniao(Participantes, dataInicial, dataFinal);
	}

  /*deve exibir um relatório com as escolhas realizadas e indicar em quais horários todos os participantes
  poderiam participar da reunião.*/
	public void mostraSobreposicao(){
    //imprime as interseccoes?
    // não sei bem se é isso mesmo rs
    reuniao.mostraSobreposicao();
	}
}