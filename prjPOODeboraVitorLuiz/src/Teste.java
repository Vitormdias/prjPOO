import fatec.poo.model.* ;

public class Teste {

    public static void main(String[] args) {
        Fiscal fisc1 = new Fiscal("1","3334445556","Carlos","R. Rosas 76");
        
        Candidato cand1 = new Candidato("001","1234567891","Jorge","R. Margarida 90");
        Candidato cand2 = new Candidato("002","7278323822","Ramalho","R. Gaitano 12");
        Concurso conc1 = new Concurso("CON1","Vestibular","12/12/2016");
        
        Prova prov1 = new Prova("Matematica",4);
        prov1.setPeso(1);
        Prova prov2 = new Prova("Matemática2", 2);
        prov2.setPeso(2);
        
        cand1.addProva(prov1);
        cand1.addProva(prov2);
        cand2.addProva(prov1);
        cand2.addProva(prov2);
        
        conc1.addPessoa(cand1);
        conc1.addPessoa(cand2);
        conc1.addProva(prov1);
        conc1.addProva(prov2);
        
        Questao q1 = new Questao(1);
        q1.setEnunciado("Quanto é 2 + 2");
        q1.setAlternativa_A("1");
        q1.setAlternativa_B("2");
        q1.setAlternativa_C("3");
        q1.setAlternativa_D("4");
        q1.setAlternativaGabarito('D');
        prov1.addQuestao(q1);
        
        Questao q2 = new Questao(2);
        q2.setEnunciado("Quanto é 2 + 2");
        q2.setAlternativa_A("1");
        q2.setAlternativa_B("2");
        q2.setAlternativa_C("3");
        q2.setAlternativa_D("4");
        q2.setAlternativaGabarito('D');
        prov1.addQuestao(q2);
        
        Questao q3 = new Questao(3);
        q3.setEnunciado("Quanto é 2 + 2");
        q3.setAlternativa_A("1");
        q3.setAlternativa_B("2");
        q3.setAlternativa_C("3");
        q3.setAlternativa_D("4");
        q3.setAlternativaGabarito('D');
        prov1.addQuestao(q3);
        
        Questao q4 = new Questao(4);
        q4.setEnunciado("Quanto é 2 + 2");
        q4.setAlternativa_A("1");
        q4.setAlternativa_B("2");
        q4.setAlternativa_C("3");
        q4.setAlternativa_D("4");
        q4.setAlternativaGabarito('D');
        prov1.addQuestao(q4);
        
        Questao questao1 = new Questao(1);
        questao1.setEnunciado("Quanto é 2 X 2");
        questao1.setAlternativa_A("1");
        questao1.setAlternativa_B("2");
        questao1.setAlternativa_C("3");
        questao1.setAlternativa_D("4");
        questao1.setAlternativaGabarito('D');
        prov2.addQuestao(questao1);
        
        Questao questao2 = new Questao(2);
        questao2.setEnunciado("Quanto é 2 X 2");
        questao2.setAlternativa_A("1");
        questao2.setAlternativa_B("2");
        questao2.setAlternativa_C("3");
        questao2.setAlternativa_D("4");
        questao2.setAlternativaGabarito('D');
        prov2.addQuestao(questao2);
                
    }
    
}
