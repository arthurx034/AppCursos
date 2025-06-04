package com.example.aplicativodecursos.model;

public class Pessoa {

    //criar os atributos
    private String primeiroNome;
    private String sobrenome;
    private String telefoneContato;

    //criar os contrutores
    public Pessoa() {
    }


    //criar os get and sets


    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }


    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    //método toString

    @Override
    public String toString() {
        return "Pessoa Salva: " + primeiroNome + sobrenome + "\n" +
                "Telefone de Contato: " + telefoneContato;
    }
}