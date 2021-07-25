public class Sala {
  private int capacidade;
  private String nome;
  private String local;
  private String observacoes;

  public Sala(String nome, String local, String observacoes, int capacidade) {
    this.capacidade = capacidade;
    this.nome = nome;
    this.local = local;
    this.observacoes = observacoes;
  }

  String getNome() {
    return this.nome;
  }

  int getCapacidade() {
    return this.capacidade;
  }

  String getObservacoes() {
    return this.observacoes;
  }
}