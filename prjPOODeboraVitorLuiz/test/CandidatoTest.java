/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fatec.poo.model.Candidato;
import fatec.poo.model.Prova;
import fatec.poo.model.Questao;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author LuizGuilherme
 */
public class CandidatoTest {
    
   private Candidato candidato;
    
    public CandidatoTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("BEFORE CLASS");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("AFTER");
    }
    
    @Before
    public void setUpCandidato() {
        System.out.println("BEFORE");
        String inscricao = "001";
        String cpf = "391";
        String nome = "Ricardo";
        String endereco = "rua dos bobos";
        candidato = new Candidato(inscricao, cpf, nome, endereco);  
    }
    

    /**
     * Test of getInscricao method, of class Candidato.
     */
    @Test
    public void testGetInscricao() {
        assertEquals(candidato.getInscricao(), "001");
    }
    
    @Test
    public void testCandidatoProva() {
        String materia = "Matematica";
        int qtdeQuestoes = 1;
        int peso = 2;
        Prova prova = new Prova(materia, qtdeQuestoes);
        prova.setPeso(peso);
        
        int numQuestao = 1;
        Questao questao = new Questao(numQuestao);
        questao.setAlternativaGabarito('B');
        questao.setResposta('B');
        
        prova.addQuestao(questao);
        candidato.addProva(prova);
        
        for(Prova p : candidato.getProvas()) {
            p.efetuarCorrecao();
        }
        
        candidato.calcularMedia();
        assertEquals(""+candidato.getMedia(), "1.0");
    }
    
    @Test
    public void testCandidatosProvas() {
        
        Prova prova = new Prova("Matematica", 2);
        prova.setPeso(1);
        
        Questao questao = new Questao(1);
        questao.setResposta('D');
        questao.setAlternativaGabarito('D');
        prova.addQuestao(questao);
        
        questao = new Questao(2);
        questao.setResposta('E');
        questao.setAlternativaGabarito('E');
        prova.addQuestao(questao);
        
        prova.efetuarCorrecao();
        
        candidato.addProva(prova);
        
        prova = new Prova("Portugues", 2);
        prova.setPeso(2);
        
        questao = new Questao(1);
        questao.setResposta('A');
        questao.setAlternativaGabarito('B');
        prova.addQuestao(questao);
        
        questao = new Questao(2);
        questao.setResposta('E');
        questao.setAlternativaGabarito('E');
        prova.addQuestao(questao);
        
        prova.efetuarCorrecao();
        
        candidato.addProva(prova);
        
        //
        
        Candidato candidato2 = new Candidato("002","222","Junior","Rua das nacoes");
        
        prova = new Prova("Fisica", 2);
        prova.setPeso(1);
        
        questao = new Questao(1);
        questao.setResposta('C');
        questao.setAlternativaGabarito('A');
        prova.addQuestao(questao);
        
        questao = new Questao(2);
        questao.setResposta('D');
        questao.setAlternativaGabarito('B');
        prova.addQuestao(questao);
        
        prova.efetuarCorrecao();
        
        candidato2.addProva(prova);
        
        prova = new Prova("Quimica", 2);
        prova.setPeso(1);
        
        questao = new Questao(1);
        questao.setResposta('A');
        questao.setAlternativaGabarito('B');
        prova.addQuestao(questao);
        
        questao = new Questao(2);
        questao.setResposta('E');
        questao.setAlternativaGabarito('E');
        prova.addQuestao(questao);
        
        prova.efetuarCorrecao();
        
        candidato2.addProva(prova);
        
        candidato.calcularMedia();
        assertEquals(""+candidato.getMedia(), ""+4/3.0);
        candidato2.calcularMedia();
        assertEquals(""+candidato2.getMedia(), "0.5"); 
}
}