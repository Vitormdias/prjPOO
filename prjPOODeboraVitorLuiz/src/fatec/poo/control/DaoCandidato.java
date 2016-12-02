

package fatec.poo.control;

import fatec.poo.model.Candidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoCandidato {
         private Connection conn;
    
    public DaoCandidato(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Candidato candidato) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbcandidato(inscricao, cpf, nome, endereco, telefone, email, media) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, candidato.getInscricao());
            ps.setString(2, candidato.getCpf());
            ps.setString(3, candidato.getNome());
            ps.setString(4, candidato.getEndereco());
            ps.setString(5, candidato.getTelefone());
            ps.setString(6, candidato.getEmail());
            ps.setDouble(7, candidato.getMedia());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Candidato candidato) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbcandidato set Inscricao = ? , Cpf = ? , Nome = ? , Endereco = ? , Telefone = ? , Email = ? ,Media = ?" +
                                                 "where inscricao = ?");
            ps.setString(1, candidato.getInscricao());
            ps.setString(2, candidato.getCpf());
            ps.setString(3, candidato.getNome());
            ps.setString(4, candidato.getEndereco());
            ps.setString(5, candidato.getTelefone());
            ps.setString(6, candidato.getEmail());
            ps.setDouble(7, candidato.getMedia());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  Candidato consultar (String inscricao) {
        Candidato c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbCandidato where " +
                                                 "inscricao = ?");
            
            ps.setString(1, inscricao);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                c = new Candidato (inscricao, rs.getString("CPF"), rs.getString("Nome"), rs.getString("Endereco"));
                
                c.setTelefone(rs.getString("Telefone"));
                c.setEmail(rs.getString("Email"));
                c.setMedia(rs.getDouble("Media"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (c);
    }    
    
    public void excluir(Candidato candidato) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbcandidato where Inscricao = ?");
            
            ps.setString(1, candidato.getInscricao());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}


