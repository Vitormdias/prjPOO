

package fatec.poo.control;

import fatec.poo.model.Fiscal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
            ps = conn.prepareStatement("UPDATE tbfiscal set Cpf = ? , Nome = ? , Endereco = ? , Telefone = ? , Email = ? ,Local = ?" 
                    + "where codigo = ?");
            
            ps.setString(1, fiscal.getCpf());
            ps.setString(2, fiscal.getNome());
            ps.setString(3, fiscal.getEndereco());
            ps.setString(4, fiscal.getTelefone());
            ps.setString(5, fiscal.getEmail());
            ps.setString(6, fiscal.getLocal());
            ps.setString(7, fiscal.getCodigo());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  Fiscal consultar (String codigo) {
        Fiscal f = null;
       
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * from tbFiscal where " +
                                                 "codigo = ?");
            
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                f = new Fiscal (codigo, rs.getString("CPF"), rs.getString("Nome"), rs.getString("Endereco"));
                
                f.setTelefone(rs.getString("Telefone"));
                f.setEmail(rs.getString("Email"));
                f.setLocal(rs.getString("Local"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (f);
    }    
    
    public void excluir(Fiscal fiscal) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbfiscal where codigo = ?");
            
            ps.setString(1, fiscal.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  ArrayList pesquisar() {
        ArrayList<Fiscal> fiscais = new ArrayList<>(); 
        Fiscal f = null;
       
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * from tbFiscal");
            
            ResultSet rs = ps.executeQuery();
           
            while(rs.next() == true) {
                f = new Fiscal (rs.getString("codigo"), rs.getString("CPF"), rs.getString("Nome"), rs.getString("Endereco"));                   
                f.setTelefone(rs.getString("Telefone"));
                f.setEmail(rs.getString("Email"));
                f.setLocal(rs.getString("Local"));
                fiscais.add(f);
                
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (fiscais);
    }
}


