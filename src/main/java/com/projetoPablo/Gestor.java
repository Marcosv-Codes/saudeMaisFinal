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
        System.out.println("\n======= 📊 MONITORANDO FILAS DE ESPERA =======");
        UPA upa = getUpaAlocado();
        System.out.println("Filas da UPA " + upa.getNome());
        System.out.println("Verde: " + upa.getFilaVerde().size());
        System.out.println("Amarela: " + upa.getFilaAmarela().size());
        System.out.println("Vermelha: " + upa.getFilaVermelha().size());
        System.out.println("=====================================");
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        // SEM LOGICA
    }

    public void gerarRelatorioSimples() {
        UPA upa = getUpaAlocado();

        System.out.println("\n======= 📊 RELATÓRIO SIMPLES =======");
        System.out.println("🟢 Pacientes atendidos VERDE: " + upa.getAtendidosVerde());
        System.out.println("🟡 Pacientes atendidos AMARELA: " + upa.getAtendidosAmarela());
        System.out.println("🔴 Pacientes atendidos VERMELHA: " + upa.getAtendidosVermelha());
        System.out.println("=====================================");

    }
} //