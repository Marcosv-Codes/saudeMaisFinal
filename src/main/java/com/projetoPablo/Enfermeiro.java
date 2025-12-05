package com.projetoPablo;

public class Enfermeiro extends Funcionario{
    // TALVEZ ACRESCENTAR UMA AREA DE TRABALHO PARA O ENFERMEIRO... SENDO: TRIAGEM OU ENFERMARIA (PARECIDO COM A DO MEDICO)

    // CONSTRUTOR
    public Enfermeiro(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
    }

    // MÉTODOS
    public void triarPaciente(Paciente paciente, Prioridade prioridade){
        if (paciente == null) {
            System.out.println("⚠️ Paciente inválido.");
            return;
        }

        paciente.setPrioridade(prioridade);

        System.out.println("======================================================================");
        System.out.println("✅ TRIAGEM REALIZADA COM SUCESSO");
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("📌 Prioridade definida: " + prioridade);

        switch (prioridade) {
            case VERDE -> System.out.println("🟢 Caso leve. Atendimento por ordem de chegada.");
            case AMARELA -> System.out.println("🟡 Caso moderado. Atendimento prioritário.");
            case VERMELHA -> System.out.println("🔴 Caso grave! Atendimento imediato.");
        }

        System.out.println("🏥 Paciente liberado para fazer o cadastro e ser adicionado a " + prioridade + " da UPA " + getUpaAlocado().getNome());
        System.out.println("======================================================================");
    }

    public void finalizarAtendimento(Paciente paciente) {
        if (paciente == null) {
            System.out.println("⚠️ Paciente inválido, não pode finalizar.");
            return;
        }

        UPA upa = getUpaAlocado();
        if (upa == null) {
            System.out.println("⚠️ Enfermeiro não está alocado em nenhuma UPA.");
            return;
        }

        System.out.println("======================================================================");
        System.out.println("👩‍⚕️ Atendimento na enfermaria finalizado!");
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("💉 Procedimento concluído na ENFERMARIA da UPA " + upa.getNome());
        System.out.println("🟢 Não necessita médico → liberado(a)!");

        // chamada para remover da fila e dar alta
        boolean alta = upa.removerPaciente(paciente);
        if (!alta) {
            System.out.println("⚠️ O(a) paciente não estava na fila, verifique o fluxo.");
        }

        getUpaAlocado().registrarAtendimento(paciente.getPrioridade());

        System.out.println("📃 Status: Alta registrada pelo(a) enfermeiro(a) " + getNome() + " ✅");
        System.out.println("======================================================================");
    }

    public void encaminharParaMedico(Paciente paciente) {
        if (paciente == null) {
            System.out.println("⚠️ Paciente inválido, não pode encaminhar.");
            return;
        }

        if (paciente.getPrioridade() == null) {
            System.out.println("⚠️ O paciente " + paciente.getNome() + " não foi triado ainda.");
            return;
        }

        UPA upa = getUpaAlocado();
        if (upa == null) {
            System.out.println("⚠️ Enfermeiro não está alocado em nenhuma UPA.");
            return;
        }

        System.out.println("======================================================================");
        System.out.println("👩‍⚕️ ENFERMEIRO EM ATENDIMENTO");
        System.out.println("🩺 Enfermeiro(a): " + getNome());
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("🚦 Prioridade atual: " + paciente.getPrioridade());
        System.out.println("🏥 Será atendido(a) por um médico da UPA " + upa.getNome());
        System.out.println("📌 Status: Sem melhora após medicação → Aguarda atendimento médico!");
        System.out.println("======================================================================");
    }
}
