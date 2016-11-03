package fatec.poo.model;

public class Prova{
  private String materia;
  private int peso, qtdeQuestoes;
  private double nota;
  private Questao[] questoes;
  private Concurso concurso;
  private Candidato candidato;
  
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
  
  public double efetuarCorrecao() {
	 int corretas = 0;
	 
	 for(Questao questao : questoes) {
		 if(questao.alternativaGabarito == questao.resposta) {
			 corretas += 1;
		 }
	 }
	 
	 nota = ((corretas * 100) / qtdeQuestoes) / 10;
  }
}
