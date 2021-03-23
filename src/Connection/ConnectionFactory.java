/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K_programmer
 */
public class ConnectionFactory {
    
    private static final String DRIVER="org.postgresql.Driver";
    private static final String URL="jdbc:postgresql://localhost:5432/clinica";  
    private static final String USER="postgres";
    private static final String PASSWORD="0000";
    
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
            throw  new RuntimeException("erro",ex);
        }
    }
    public static void closeConnection(Connection con){
            try {
        if(con!=null){
       
                con.close();
        }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection con,Statement stm){
        closeConnection(con);
        
             try {
        if(stm!=null){
       
                stm.close();
        }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      public static void closeConnection(Connection con,Statement stm,ResultSet rs){
        closeConnection(con,stm);
        
             try {
        if(rs!=null){
       
                rs.close();
        }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
       
       
       
    

