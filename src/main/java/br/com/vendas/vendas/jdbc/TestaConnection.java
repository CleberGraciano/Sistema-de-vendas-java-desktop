package br.com.vendas.vendas.jdbc;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleber
 */
public class TestaConnection {
    
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showConfirmDialog(null, "Conectado com sucesso!!");
        } catch (HeadlessException e) {
            JOptionPane.showConfirmDialog(null, "Ops aconteceu o erro : "+ e);
        }
    }
    
}
