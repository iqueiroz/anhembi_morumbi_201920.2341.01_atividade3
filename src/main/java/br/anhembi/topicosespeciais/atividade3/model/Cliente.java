package br.anhembi.topicosespeciais.atividade3.model;

public class Cliente {
    private int _id;
    private String _nome;
    private String _cpf;
    private String _rg;
    private String _email;
    private String _telefone;
    private String _cep;

    public Cliente(int id, String nome, String cpf, String rg, String email, String telefone, String cep) {
        this._id = id;
        this._nome = nome;
        this._cpf = cpf;
        this._rg = rg;
        this._email = email;
        this._telefone = telefone;
        this._cep = cep;
    }
    
    public int getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    public String getCpf() {
        return _cpf;
    }

    public String getRg() {
        return _rg;
    }

    public String getEmail() {
        return _email;
    }

    public String getTelefone() {
        return _telefone;
    }

    public String getCep() {
        return _cep;
    }

    
    
}
