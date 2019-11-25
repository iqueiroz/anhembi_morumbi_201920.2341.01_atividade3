package br.anhembi.topicosespeciais.atividade3.dataAccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfiguration {

    private String _connectionUri;
    private String _username;
    private String _password;

    public DatabaseConfiguration() {
        try {
            this.initialize();
        } catch(Exception ex) {
          System.out.println("Exception: " + ex);  
        }
    }
    
    public String getConnectionUri() {
        return this._connectionUri;
    }
    
    public String getUsername() {
        return this._username;
    }
    
    public String getPassword() {
        return this._password;
    }

    private void initialize() {
            // carrega as propriedades do arquivo
            String host = "localhost";
            String porta = "3306";
            String banco = "cadastro";
            
            this._connectionUri = "jdbc:mysql://" + host + ":" + porta + "/" + banco;
            
            String usuario = "user";
            String senha = "password";
            this._username = usuario;
            this._password = senha;
    }

}
