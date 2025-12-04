package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class UPA {
    // ATRIBUTOS
    private String nome;
    private String endereco;
    private ArrayList<Paciente> filaVerde;
    private ArrayList<Paciente> filaAmarela;
    private ArrayList<Paciente> filaVermelha;

    // CONTADORES
    private int atendidosVerde = 0;
    private int atendidosAmarela = 0;
    private int atendidosVermelha = 0;

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Paciente> getFilaVerde() {
        return filaVerde;
    }

    public void setFilaVerde(ArrayList<Paciente> filaVerde) {
        this.filaVerde = filaVerde;
    }

    public ArrayList<Paciente> getFilaAmarela() {
        return filaAmarela;
    }

    public void setFilaAmarela(ArrayList<Paciente> filaAmarela) {
        this.filaAmarela = filaAmarela;
    }

    public ArrayList<Paciente> getFilaVermelha() {
        return filaVermelha;
    }

    public void setFilaVermelha(ArrayList<Paciente> filaVermelha) {
        this.filaVermelha = filaVermelha;
    }

    public int getAtendidosVerde() {
        return atendidosVerde;
    }

    public int getAtendidosAmarela() {
        return atendidosAmarela;
    }

    public int getAtendidosVermelha() {
        return atendidosVermelha;
    }

    // CONSTRUTOR
    public UPA(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.filaVerde = new ArrayList<>();
        this.filaAmarela = new ArrayList<>();
        this.filaVermelha = new ArrayList<>();
    }

    // TO-STRING
    @Override
    public String toString() {
        return "UPA{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", filaVerde=" + filaVerde +
                ", filaAmarela=" + filaAmarela +
                ", filaVermelha=" + filaVermelha +
                '}';
    }

    // MÉTODOS
    public void adicionarPacienteFila(Paciente paciente) {
        if (paciente == null) {
            System.out.println("⚠️ Paciente inválido.");
            return;
        }

        if (paciente.getPrioridade() == null) {
            System.out.println("⚠️ O paciente " + paciente.getNome() + " ainda não passou pela triagem!");
            return;
        }

        switch (paciente.getPrioridade()) {
            case VERDE:
                filaVerde.add(paciente);
                break;
            case AMARELA:
                filaAmarela.add(paciente);
                break;
            case VERMELHA:
                filaVermelha.add(paciente);
                break;
        }

        //System.out.println("✅ Paciente " + paciente.getNome() + " entrou na fila " + paciente.getPrioridade() + " da UPA " + this.nome);
    }

    public Paciente chamarProximo() {
        Paciente proximo = null;
        String filaNome = "";

        // VERIFICANDO A PRIORIDADE DA FILA

        if (!filaVermelha.isEmpty()) {
            proximo = filaVermelha.get(0);
            filaNome = "VERMELHA 🔴";
            filaVermelha.remove(0);
            registrarAtendimento(Prioridade.VERMELHA);
        }
        else if (!filaAmarela.isEmpty()) {
            proximo = filaAmarela.get(0);
            filaNome = "AMARELA 🟡";
            filaAmarela.remove(0);
            registrarAtendimento(Prioridade.AMARELA);
        }
        else if (!filaVerde.isEmpty()) {
            proximo = filaVerde.get(0);
            filaNome = "VERDE 🟢";
            filaVerde.remove(0);
            registrarAtendimento(Prioridade.VERDE);
        }
        else {
            System.out.println("⚠️ Nenhum paciente na fila no momento.");
            return null;
        }

        // 2. PRINTA AS INFORMAÇÕES DO PACIENTE CHAMADO
        System.out.println("\n==============================================");
        System.out.println("🚑 Próximo paciente chamado!");
        System.out.println("🏥 UPA: " + getNome());
        System.out.println("👤 Nome: " + proximo.getNome());
        System.out.println("🆔 CPF: " + proximo.getCpf());
        System.out.println("🚨 Fila: " + filaNome);
        System.out.println("🕒 Chegada: " + proximo.getChegadaFilaTimestamp());
        System.out.println("==============================================");

        return proximo;
        /*
        Paciente proximo = null;
        String filaNome = "";

        // Prioridade máxima primeiro
        if (!filaVermelha.isEmpty()) {
            proximo = filaVermelha.get(0);
            filaNome = "VERMELHA 🔴";
        }
        else if (!filaAmarela.isEmpty()) {
            proximo = filaAmarela.get(0);
            filaNome = "AMARELA 🟡";
        }
        else if (!filaVerde.isEmpty()) {
            proximo = filaVerde.get(0);
            filaNome = "VERDE 🟢";
        }
        else {
            System.out.println("⚠️ Nenhum paciente na fila no momento.");
            return null;
        }

        // Print simples
        System.out.println("==============================================");
        System.out.println("🚑 Próximo paciente chamado!");
        System.out.println("👤 Paciente: " + proximo.getNome());
        System.out.println("🚨 Prioridade da fila: " + filaNome);
        System.out.println("🕒 Chegada: " + proximo.getChegadaFilaTimestamp());
        System.out.println("==============================================");


        // REMOVER AQUI, pois foi chamado para atendimento
        if (filaNome.contains("VERMELHA")) filaVermelha.remove(0);
        if (filaNome.contains("AMARELA")) filaAmarela.remove(0);
        if (filaNome.contains("VERDE")) filaVerde.remove(0);

        return proximo;
        */
    }

    /*
    public double getTempoMedioEspera() {
        return 0.0; // SEM LOGICA
    }
     */

    public boolean removerPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }

        boolean removido = false;

        // Comparar usando CPF em cada fila
        if (filaVerde != null) {
            for (int i = 0; i < filaVerde.size(); i++) {
                if (filaVerde.get(i).getCpf().equals(paciente.getCpf())) {
                    filaVerde.remove(i);
                    removido = true;

                    System.out.println("======================================================================");
                    System.out.println("🎉 O paciente " + paciente.getNome() + " teve alta! 🏥");
                    System.out.println("📃 Status: Recebeu alta médica e foi removido da fila VERDE.");
                    System.out.println("======================================================================");

                    break;
                }
            }
        }

        if (!removido && filaAmarela != null) {
            for (int i = 0; i < filaAmarela.size(); i++) {
                if (filaAmarela.get(i).getCpf().equals(paciente.getCpf())) {
                    filaAmarela.remove(i);
                    removido = true;

                    System.out.println("======================================================================");
                    System.out.println("🎉 O paciente " + paciente.getNome() + " teve alta! 🏥");
                    System.out.println("📃 Status: Recebeu alta médica e foi removido da fila AMARELA.");
                    System.out.println("======================================================================");

                    break;
                }
            }
        }

        if (!removido && filaVermelha != null) {
            for (int i = 0; i < filaVermelha.size(); i++) {
                if (filaVermelha.get(i).getCpf().equals(paciente.getCpf())) {
                    filaVermelha.remove(i);
                    removido = true;

                    System.out.println("======================================================================");
                    System.out.println("🎉 O paciente " + paciente.getNome() + " teve alta! 🚑");
                    System.out.println("📃 Status: Recebeu alta médica e foi removido da fila VERMELHA.");
                    System.out.println("======================================================================");

                    break;
                }
            }
        }

        return removido;
    }

    public void registrarAtendimento(Prioridade prioridade) {
        if (prioridade == Prioridade.VERDE) atendidosVerde++;
        else if (prioridade == Prioridade.AMARELA) atendidosAmarela++;
        else if (prioridade == Prioridade.VERMELHA) atendidosVermelha++;
    }
    /*
    public int posicaoNaFila(Paciente paciente) {
        return 0; // SEM LOGICA
    }
     */
}