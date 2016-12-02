
package fatec.poo.model;

import java.util.ArrayList;

public class Candidato extends Pessoa {
    private String inscricao;
    private double media;
    private ArrayList<Prova> provas;

    public Candidato(String inscricao, String cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
        this.inscricao = inscricao;
        provas = new ArrayList<Prova>();
    }

    public String getInscricao() {
        return inscricao;
    }

    public double getMedia() {
        return media;
    }
    
    
    
    public void setMedia(double media) {
        this.media = media;
    }
    
    public void addProva(Prova p){
        provas.add(p);
        p.setCandidato(this);
    }
   
    public void calcularMedia(){
        double somaPeso =0, somaNota = 0;
        for(Prova p: provas){
            somaNota += (p.getNota() * p.getPeso());  
            somaPeso += p.getPeso();
        }    
        media = somaNota/somaPeso;
    }        

    public ArrayList<Prova> getProvas() {
        return provas;
    }
            
}
