package br.com.vendas.vendas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cleber
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas", "usuariocurso", "123");
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
}
