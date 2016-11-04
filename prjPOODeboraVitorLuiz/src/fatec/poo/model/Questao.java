package fatec.poo.model;

public class Questao {
	
	private int numero;
	private String enunciado, alternativa_A, alternativa_B, alternativa_C, alternativa_D;
	
	public char resposta, alternativaGabarito;
	
	public Questao (int numero) {
		this.numero = numero;
	}

    public int getNumero() {
        return numero;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getAlternativa_A() {
        return alternativa_A;
    }

    public String getAlternativa_B() {
        return alternativa_B;
    }

    public String getAlternativa_C() {
        return alternativa_C;
    }

    public String getAlternativa_D() {
        return alternativa_D;
    }

    public char getResposta() {
        return resposta;
    }

    public char getAlternativaGabarito() {
        return alternativaGabarito;
    }
	
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public void setAlternativa_A (String alternativa_A) {
		this.alternativa_A = alternativa_A;
	}
	
	public void setAlternativa_B (String alternativa_B) {
		this.alternativa_B = alternativa_B;
	}
	
	public void setAlternativa_C(String alternativa_C) {
		this.alternativa_C = alternativa_C;
	}
	
	public void setAlternativa_D(String alternativa_D) {
		this.alternativa_D = alternativa_D;
	}
	
	public void setResposta (char resposta) {
		this.resposta = resposta;
	}
	
	public void setAlternativaGabarito (char alternativaGabarito) {
		this.alternativaGabarito = alternativaGabarito;
	}
	
}
