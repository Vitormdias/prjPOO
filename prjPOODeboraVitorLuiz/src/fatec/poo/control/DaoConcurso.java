 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fatec.poo.control;

import fatec.poo.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuizGuilherme
 */
public class DaoConcurso {
    
    private Connection conn;
    
    public DaoConcurso(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Concurso concurso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbconcurso(sigla, descricao, dataRealizacao, taxaInscricao) VALUES(?,?,?,?)");
            ps.setString(1, concurso.getSigla());
            ps.setString(2, concurso.getDescricao());
            ps.setString(3, concurso.getDataRealizacao());
            ps.setDouble(4, concurso.getTaxaInscricao());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Concurso concurso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbconcurso set descricao = ? , dataRealizacao = ? , taxaInscricao = ?  where sigla = ?");
            
            ps.setString(1, concurso.getDescricao());
            ps.setString(2, concurso.getDataRealizacao());
            ps.setDouble(3, concurso.getTaxaInscricao());
            ps.setString(4, concurso.getSigla());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  Concurso consultar (String sigla) {
        Concurso c = null;
       
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * from tbconcurso where " +
                                                 "sigla = ?");
            
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                c = new Concurso (sigla, rs.getString("descricao"), rs.getString("dataRealizacao"));
                
                c.setTaxaInscricao(rs.getDouble("taxaInscricao"));
            
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (c);
    }    
    
    public ArrayList<Fiscal> fiscais(String sigla) {
        ArrayList<Fiscal> fiscais = new ArrayList<>(); 
        Fiscal f = null;
       
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * from tbFiscal WHERE sigla = ?");
            
            ps.setString(1, sigla);
            
            ResultSet rs = ps.executeQuery();
           
            while(rs.next() == true) {
                f = new Fiscal (rs.getString("codigo"), rs.getString("CPF"), rs.getString("Nome"), rs.getString("Endereco"));                   
                f.setTelefone(rs.getString("Telefone"));
                f.setEmail(rs.getString("Email"));
                f.setLocal(rs.getString("Local"));
                f.setSigla(rs.getString("Sigla"));
                fiscais.add(f);
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (fiscais);
    }
    
    public void excluir(Concurso concurso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbconcurso where sigla = ?");
            
            ps.setString(1, concurso.getSigla());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }

}
