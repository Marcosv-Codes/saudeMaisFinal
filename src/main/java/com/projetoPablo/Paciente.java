package com.projetoPablo;

public class Paciente extends Pessoa{
    // ATRIBUTOS
    private String email;
    private String senha;
    private Prioridade prioridade; // VERDE, AMARELA, VERMELHA
    private String chegadaFilaTimestamp;

    // GETTERS E SETTERS
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public String getChegadaFilaTimestamp() {
        return chegadaFilaTimestamp;
    }
    public void setChegadaFilaTimestamp(String chegadaFilaTimestamp) {
        this.chegadaFilaTimestamp = chegadaFilaTimestamp;
    }

    // CONSTRUTOR
    public Paciente(String nome, String cpf, String dataNascimento, String email, String senha, String chegadaFilaTimestamp) {
        super(nome, cpf, dataNascimento);
        this.email = email;
        this.senha = senha;
        this.chegadaFilaTimestamp = chegadaFilaTimestamp;
        this.prioridade = null; // inicia sem prioridade, definida na triagem
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Paciente{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", chegadaFilaTimestamp='" + chegadaFilaTimestamp + '\'' +
                "} " + super.toString();
    }

    // MÉTODOS
    public boolean login(String email, String senha){
        // VERIFICA VALORES NULOS
        if(email == null || this.email == null || senha == null || this.senha == null){
            return false;
        }

        // COMPARA O E-MAIL E SENHA INSERIDOS:
        boolean emailCorreto = this.email.equals(email);
        boolean senhaCorreta = this.senha.equals(senha);
        boolean logouComSucesso = emailCorreto && senhaCorreta;

        if(logouComSucesso) {
            System.out.println("Verificando email e senha...");
            System.out.println(getNome() + " Logado com sucesso!");
        } else {
            System.out.println("Login falhou! E-mail ou senha incorretos!");
        }

        return logouComSucesso;
    }
    /*
    public double verTempoEspera(){
        double tempoEspera = 0.0;
        return tempoEspera; // FALTA A LOGICA
    }
     */
} //
