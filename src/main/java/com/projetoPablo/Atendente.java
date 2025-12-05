package com.projetoPablo;

public class Atendente extends Funcionario {
    // CONSTRUTOR
    public Atendente(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
    }

    // MÉTODOS
    public void cadastrarPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("⚠️ Não é possível cadastrar: paciente inválido.");
            return;
        }

        if (paciente.getPrioridade() == null) {
            System.out.println("⚠️ O paciente " + paciente.getNome() + " ainda não passou pela triagem.");
            return;
        }

        System.out.println("======================================================================");
        System.out.println("📋 CADASTRO REALIZADO");
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("🆔 CPF: " + paciente.getCpf());
        System.out.println("📧 Email: " + paciente.getEmail());
        System.out.println("🚦 Prioridade da triagem: " + paciente.getPrioridade());
        System.out.println("⏰ Horário de chegada: " + paciente.getChegadaFilaTimestamp());
        System.out.println("✅ Status: cadastrado no sistema e liberado para fila.");
        System.out.println("======================================================================");
    }

    public void adicionarFila(Paciente paciente, UPA upa) {
        if (paciente == null) {
            System.out.println("⚠️ Paciente inválido.");
            return;
        }
        try {
            // chama a lógica da UPA para inserir na fila correta
            upa.adicionarPacienteFila(paciente);

            // print simples do atendente confirmando
            System.out.println("📞 O Atendente " + getNome() + " adicionou o(a) paciente "
                    + paciente.getNome() + " na fila " + paciente.getPrioridade()
                    + " da UPA " + upa.getNome());
        } catch (PacienteInvalidoException erro) {
            System.out.println(erro.getMessage());
        }
    }
}