package br.com.vendas.dao;

import br.com.vendas.vendas.jdbc.ConnectionFactory;
import br.com.vendas.vendas.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleber
 */
public class ClientesDAO {
    
    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    
    public void cadastrarCliente(Clientes obj){
        try {
           
            //1 Passo - Criar o comando sql 
            String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "     values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            
            //2 Passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());    
            
            stmt.execute();
            stmt.close();
            JOptionPane.showConfirmDialog(null, "Cadastrado com sucesso!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showConfirmDialog(null, "Erro ao cadastrar Usuário!"+e);
            
        }
    }
    
    public void alterarCliente(Clientes obj){
        
         try {
           
            //1 Passo - Criar o comando sql 
            String sql = "update tb_clientes set nome = ?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id = ?;";
     
            
            //2 Passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());    
            stmt.setInt(14, obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showConfirmDialog(null, "Alterado com sucesso!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showConfirmDialog(null, "Erro ao alterar Usuário!"+e);
            
        }
    }
    
    public void excluirCliente(Clientes obj){
        
         try {
           
            //1 Passo - Criar o comando sql 
            String sql = "delete from tb_clientes where id= ?";
            
            //2 Passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
           
            stmt.execute();
            stmt.close();
            JOptionPane.showConfirmDialog(null, "Excluido com sucesso!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showConfirmDialog(null, "Erro ao excluir Cliente!"+e);
            
        }
        
    }
    
    public List<Clientes> listarClientes(){
        
        try {
            
            List<Clientes> lista = new ArrayList<>();
            
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
                 
            }
            
            return lista;
            
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro: "+e);
            return null;
        }  
    }
    
    
    public List<Clientes> listarClientePorNome(String nome){
        
        try {
            
            List<Clientes> lista = new ArrayList<>();
            
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
                 
            }
            
            return lista;
            
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro: "+e);
            return null;
        }  
    }
    
    
}
