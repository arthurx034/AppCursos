package com.arthur.aplicativodecursos.model;

public class Pessoa {

    //criar os atributos
    private String primeiroNome;
    private String sobrenome;
    private String telefoneContato;

    //criar os contrutores
    public Pessoa() {
    }

    public Pessoa(String primeiroNome, String sobrenome, String telefoneContato) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.telefoneContato = telefoneContato;
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
        if (!primeiroNome.isEmpty() && !sobrenome.isEmpty() && !telefoneContato.isEmpty()) {
            return "Pessoa Salva: " + primeiroNome + " " + sobrenome + " " + telefoneContato;
        }
        return "Digite os dados corretamente";
    }
}