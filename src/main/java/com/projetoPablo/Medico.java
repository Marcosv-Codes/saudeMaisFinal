package com.projetoPablo;

public class Medico extends Funcionario{
    // ATRIBUTOS
    private Prioridade areaTrabalho; // VERDE, AMARELO, VERMELHO

    // CONSTRUTOR
    public Medico(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado, Prioridade areaTrabalho) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
        this.areaTrabalho = areaTrabalho;
    }

    // GETTERS E SETTERS
    public Prioridade getAreaTrabalho() {
        return areaTrabalho;
    }

    public void setAreaTrabalho(Prioridade areaTrabalho) {
        this.areaTrabalho = areaTrabalho;
    }

    // MÉTODOS
    public void atenderPaciente(Paciente paciente) {
        // SEM LOGICA
    }

    public void encaminharParaEnfermaria(Paciente paciente) {
        // SEM LOGICA
    }

    public void finalizarAtendimento(Paciente paciente) {
        // SEM LOGICA
    }
}