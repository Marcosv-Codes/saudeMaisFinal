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
        if (paciente == null) {
            System.out.println("⚠️ Não é possível atender: paciente inválido.");
            return;
        }

        System.out.println("======================================================================");
        System.out.println("👩‍⚕️ MÉDICO EM ATENDIMENTO");
        System.out.println("🩺 Médico(a): " + getNome());  // print do medico autenticado/alocado
        System.out.println("👤 Paciente atendido(a): " + paciente.getNome());
        System.out.println("📌 Prioridade do caso: " + paciente.getPrioridade());
        System.out.println("📋 Consulta iniciada... ✅");
        System.out.println("======================================================================");
    }

    public void encaminharParaEnfermaria(Paciente paciente) {
        if (paciente == null) {
            System.out.println("⚠️ Não é possível encaminhar: paciente inválido.");
            return;
        }

        UPA upa = getUpaAlocado();
        if (upa == null) {
            System.out.println("⚠️ Médico(a) não está alocado em nenhuma UPA.");
            return;
        }

        System.out.println("======================================================================");
        System.out.println("🏥 ENCAMINHADO PARA A ENFERMARIA");
        System.out.println("🩺 Médico(a) responsável: " + getNome());
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("💉 Encaminhamento realizado para ENFERMARIA da UPA " + upa.getNome());
        System.out.println("======================================================================");
    }

    public void finalizarAtendimento(Paciente paciente) {
        if (paciente == null) {
            System.out.println("⚠️ Paciente inválido, não pode finalizar.");
            return;
        }

        UPA upa = getUpaAlocado();
        if (upa == null) {
            System.out.println("⚠️ Médico(a) não está alocado em nenhuma UPA.");
            return;
        }

        System.out.println("======================================================================");
        System.out.println("🩺 Atendimento médico finalizado!");
        System.out.println("👨‍⚕️ Médico(a): " + getNome());
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("🏥 Consulta/atendimento concluído na UPA " + upa.getNome());
        System.out.println("✅ ALTA médica concedida!");

        boolean alta = upa.removerPaciente(paciente);
        if (!alta) {
            System.out.println("⚠️ O(a) paciente não estava na fila, verifique o fluxo.");
        }

        System.out.println("📃 Status: Alta registrada pelo(a) médico(a) " + getNome() + " ✅");
        System.out.println("======================================================================");
    }
}