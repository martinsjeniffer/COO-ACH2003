import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reuniao {
    private ArrayList<Participante> participantes;
    private ArrayList<Disponibilidade> listaInterseccoes; 
    private LocalDate inicioIntervalo;
    private LocalDate finalIntervalo;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public Reuniao(ArrayList<Participante> participantes, LocalDate inicioIntervalo, LocalDate finalIntervalo){
        this.participantes = participantes;
        this.inicioIntervalo = inicioIntervalo;
        this.finalIntervalo = finalIntervalo;
        this.listaInterseccoes = new ArrayList<>();
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes; 
    }

    public LocalDate getInicioIntervalo() {
        return inicioIntervalo;
    }

    public LocalDate getFinalIntervalo() {
        return finalIntervalo;
    }

    public ArrayList<Disponibilidade> getInterseccoes(){
      return listaInterseccoes;
    }
    
    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public void setInicioIntervalo(LocalDate inicioIntervalo) {
        this.inicioIntervalo = inicioIntervalo;
    }

    public void setFinalIntervalo(LocalDate finalIntervalo) {
        this.finalIntervalo = finalIntervalo;
    }
