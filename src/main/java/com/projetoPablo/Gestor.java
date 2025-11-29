package com.projetoPablo;

public class Gestor extends Funcionario{
    // CONSTRUTOR
    public Gestor(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
    }

    // MÉTODOS
    public void cadastrarUPA(UPA upa) {
        // SEM LOGICA
    }

    public void monitorarFilas() {
        // SEM LOGICA
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        // SEM LOGICA
    }

    public String gerarRelatorioSimples() {

        return null; // SEM LOGICA
    }
}