package com.projetoPablo;

public abstract class Funcionario extends Pessoa {
    // ATRIBUTOS
    private String matricula;
    private String senha;
    private UPA upaAlocado;


    // GETTERS E SETTERS
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public UPA getUpaAlocado() {
        return upaAlocado;
    }
    public void setUpaAlocado(UPA upaAlocado) {
        this.upaAlocado = upaAlocado;
    }

    // CONSTRUTOR
    public Funcionario(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
        this.senha = senha;
        this.upaAlocado = upaAlocado;
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula='" + matricula + '\'' +
                ", upaAlocado=" + upaAlocado +
                "} " + super.toString();
    }

    // MÉTODOS
    public boolean autenticar(String senha) {

        // FALTA TESTAR
        if (senha == null || this.senha == null) {
            return false;
        }
        // COMPARA A MATRÍCULA E SENHA INSERIDAS:
        boolean matriculalCorreta = this.matricula.equals(matricula);
        boolean senhaCorreta = this.senha.equals(senha);
        boolean autenticadoComSucesso = matriculalCorreta && senhaCorreta;

        if(autenticadoComSucesso) {
            System.out.println("Funcionário autenticado com sucesso!");
        } else {
            System.out.println("Autentição falhou! Matrícula ou senha incorretos!");
        }

        return autenticadoComSucesso;
    }
}
