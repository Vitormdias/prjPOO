package fatec.poo.model;

public class Prova{
  private String materia;
  private int peso, qtdeQuestoes;
  private double nota;
  private Questao[] questoes;
  private Concurso concurso;
  private Candidato candidato;

  int questoesAdd = 0;

  public Prova(String materia, int qtdeQuestoes) {
  	   this.materia = materia;
  	   this.qtdeQuestoes = qtdeQuestoes;
  	   questoes = new Questao[qtdeQuestoes];
  }

  public void setPeso(int peso) {
	     this.peso = peso;
  }

  public void setConcurso(Concurso concurso) {
	     this.concurso = concurso;
  }

  public void setCandidato(Candidato candidato) {
	     this.candidato = candidato;
  }

  public int getPeso() {
       return peso;
  }

  public Candidato getCandidato() {
	     return candidato;
  }

  public Concurso getConcurso() {
	     return concurso;
  }

  public String getMateria() {
	     return materia;
  }

  public double getNota() {
	     return nota;
  }

  public int getQtdeQuestoes() {
	     return qtdeQuestoes;
  }

  public void efetuarCorrecao() {

	     for(Questao questao : questoes) {
    		 if(questao.getAlternativaGabarito() == questao.getResposta()) {
    			 nota += 1;
    		 }
	      }

  }

  public void addQuestao(Questao q) {
      if(questoesAdd < qtdeQuestoes) {
        questoes[questoesAdd++] = q;
      }
      else {
        System.out.println("Limite de questoes excedido");
      }
  }

  public Questao[] getQuestoes() {
       return questoes;
  }

}
