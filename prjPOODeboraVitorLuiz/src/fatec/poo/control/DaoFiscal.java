

package fatec.poo.control;

import fatec.poo.model.Fiscal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoFiscal {
         private Connection conn;
    
    public DaoFiscal(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Fiscal fiscal) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbfiscal(codigo, cpf, nome, endereco, telefone, email, local) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, fiscal.getCodigo());
            ps.setString(2, fiscal.getCpf());
            ps.setString(3, fiscal.getNome());
            ps.setString(4, fiscal.getEndereco());
            ps.setString(5, fiscal.getTelefone());
            ps.setString(6, fiscal.getEmail());
            ps.setString(7, fiscal.getLocal());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Fiscal fiscal) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbfiscal set Codigo = ? , Cpf = ? , Nome = ? , Endereco = ? , Telefone = ? , Email = ? ,Local = ?" +
                                                 "where inscricao = ?");
            ps.setString(1, fiscal.getCodigo());
            ps.setString(2, fiscal.getCpf());
            ps.setString(3, fiscal.getNome());
            ps.setString(4, fiscal.getEndereco());
            ps.setString(5, fiscal.getTelefone());
            ps.setString(6, fiscal.getEmail());
            ps.setString(7, fiscal.getLocal());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  Fiscal consultar (String codigo) {
        Fiscal c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbfiscal where " +
                                                 "inscricao = ?");
            
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                c = new Fiscal (codigo, rs.getString("CPF"), rs.getString("Nome"), rs.getString("Endereco"));
                
                c.setTelefone(rs.getString("Telefone"));
                c.setEmail(rs.getString("Email"));
                c.setLocal(rs.getString("Local"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (c);
    }    
    
    public void excluir(Fiscal fiscal) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbfiscal where Inscricao = ?");
            
            ps.setString(1, fiscal.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}


