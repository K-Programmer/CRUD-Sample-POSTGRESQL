/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Medico;

/**
 *
 * @author K_programmer
 */
public class MedicoDAO {
    
    public void insert(Medico m){
        Connection con=  ConnectionFactory.getConnection();
        PreparedStatement stm=null;
        
        try {
            stm=con.prepareStatement("insert into medico(nome,,bi,morada)values(?,?,?)");
            stm.setString(1, m.getNome());
             stm.setString(2, m.getBi());
            stm.setString(3, m.getMorada());
         
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso", "Processo", 1);
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stm);
        }
        
        
        
    }
    
    public void update(Medico m){
        Connection con=  ConnectionFactory.getConnection();
        PreparedStatement stm=null;
        
        try {
            stm=con.prepareStatement("update medico set nome=?, bi=?, morada=? where id=?");
            stm.setString(1, m.getNome());
             stm.setString(2, m.getBi());
            stm.setString(3, m.getMorada());
            stm.setInt(4, m.getCod());
         
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Editado com sucesso", "Processo", 1);
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stm);
        }
        
        
        
    }
    
    public ArrayList<Medico> Lista(){
        Connection con=  ConnectionFactory.getConnection();
        PreparedStatement stm=null;
         // ArrayList<Medico> medicoList = null;
         ArrayList<Medico> medicoList =new ArrayList<>();
        try {
            stm=con.prepareStatement("select *from medico");
           
         
            
           ResultSet  rs= stm.executeQuery();
            
    while (rs.next()) {
     
        Medico medico = new Medico( );
         medico.setCod(rs.getInt("id"));
        medico.setNome(rs.getString("nome"));
        medico.setBi(rs.getString("bi"));
         medico.setMorada(rs.getString("morada"));
        medicoList.add(medico);
    }
    
           
           //return medicoList;  
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stm);
        }
        
     
      return medicoList;    
    }
    
     
}
