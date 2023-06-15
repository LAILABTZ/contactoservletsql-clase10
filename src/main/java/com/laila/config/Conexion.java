/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laila.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private Connection jdbcConnection;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    
    public Conexion(){
        this.jdbcURL = "jdbc:mysql://root:FXiFKNkDcAOmYGuyp48B@containers-us-west-100.railway.app:7152/railway?useSSL=false";
        this.jdbcUsername = "root"; //root
        this.jdbcPassword = "FXiFKNkDcAOmYGuyp48B";
    }
    
    public void conectar() throws SQLException{
        if(jdbcConnection == null || jdbcConnection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e){
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    
    public void desconectar() throws SQLException{
        if(jdbcConnection != null && !jdbcConnection.isClosed() ){
            jdbcConnection.close();
        }
    }
    
    public Connection getJdbcConnection(){
        return jdbcConnection;
    }
}
