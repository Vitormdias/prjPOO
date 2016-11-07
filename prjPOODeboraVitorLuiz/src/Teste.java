import fatec.poo.model.* ;

public class Teste {

    public static void main(String[] args) {
        Fiscal fisc1 = new Fiscal("1","3334445556","Carlos","R. Rosas 76");
        
        Candidato cand3 = new Candidato("003","7278323822","Ramalho","R. Gaitano 12");
        Concurso conc1 = new Concurso("CON1","Vestibular","12/12/2016");
        
        Prova prov5 = new Prova("Matemática1", 1);
        prov5.setPeso(1);

        cand3.addProva(prov5);
        
        conc1.addPessoa(cand3);
        conc1.addProva(prov5);
        
        Questao q1 = new Questao(1);
        q1.setEnunciado("Quanto é 2 + 2");
        q1.setAlternativa_A("1");
        q1.setAlternativa_B("2");
        q1.setAlternativa_C("3");
        q1.setAlternativa_D("4");
        q1.setAlternativaGabarito('D');

        prov5.addQuestao(q1);
        
        for(Prova p: cand3.getProvas()){
            for(Questao q: p.getQuestoes()){
             q.setResposta('D');
            }
        }
                
        for(Prova p: cand3.getProvas()){
            p.efetuarCorrecao();
            
        }

        cand3.calcularMedia();
        
        System.out.println("Média candidato 3: " + cand3.getMedia());
        
    }
    
}
