package br.anhembi.topicosespeciais.atividade3.dataAccess;

import br.anhembi.topicosespeciais.atividade3.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRepository {

    private DatabaseConnection _connection;

    public ClienteRepository(DatabaseConnection connection) {
        this._connection = connection;
    }
    
    public Cliente Primeiro() throws SQLException {
        String sql = "SELECT * FROM cliente ORDER BY id LIMIT 1";
        
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Cliente result = null;
        if (rs.next()) {
            Cliente cliente = lerCliente(rs);
            result = cliente;
        }
        return result;
    }
    
    public Cliente Ultimo() throws SQLException {
        String sql = "SELECT * FROM cliente ORDER BY id DESC LIMIT 1";
        
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Cliente result = null;
        if (rs.next()) {
            Cliente cliente = lerCliente(rs);
            result = cliente;
        }
        return result;
    }
    
    public Cliente Proximo(Cliente referencia) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id > ? ORDER BY id LIMIT 1";
        
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, referencia.getId());
        ResultSet rs = pstmt.executeQuery();
        Cliente result = null;
        if (rs.next()) {
            Cliente cliente = lerCliente(rs);
            result = cliente;
        }
        return result;
    }
    
    public Cliente Anterior(Cliente referencia) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id < ? ORDER BY id DESC LIMIT 1";
        
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, referencia.getId());
        ResultSet rs = pstmt.executeQuery();
        Cliente result = null;
        if (rs.next()) {
            Cliente cliente = lerCliente(rs);
            result = cliente;
        }
        return result;
    }
    
    public Cliente Pesquisar(String cpf) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE cpf = ? ORDER BY id LIMIT 1";
        
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        pstmt.setString(1, cpf);
        ResultSet rs = pstmt.executeQuery();
        Cliente result = null;
        if (rs.next()) {
            Cliente cliente = lerCliente(rs);
            result = cliente;
        }
        return result;
    }
    
    public void Inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(nome,cpf,rg,email,telefone,cep) VALUES(?,?,?,?,?,?)";
 
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getCpf());
        pstmt.setString(3, cliente.getRg());
        pstmt.setString(4, cliente.getEmail());
        pstmt.setString(5, cliente.getTelefone());
        pstmt.setString(6, cliente.getCep());
        pstmt.executeUpdate();

    }
    
    public void Atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente set nome=?, cpf=?, rg=?, email=?, telefone=?, cep=? WHERE id=?";
 
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getCpf());
        pstmt.setString(3, cliente.getRg());
        pstmt.setString(4, cliente.getEmail());
        pstmt.setString(5, cliente.getTelefone());
        pstmt.setString(6, cliente.getCep());
        pstmt.setInt(7, cliente.getId());
        pstmt.executeUpdate();

    }
    
    public void Excluir(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id=?";
 
        PreparedStatement pstmt = this._connection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    }

    private Cliente lerCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("rg"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("cep"));
        return cliente;
    }
    
}
