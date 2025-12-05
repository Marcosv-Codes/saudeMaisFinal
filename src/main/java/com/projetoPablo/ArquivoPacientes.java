package com.projetoPablo;

import java.io.*;
import java.util.List;

public class ArquivoPacientes {

    private static final String ARQUIVO_FILA = "fila_pacientes.csv";

    // Grava os pacientes que ainda estão nas filas
    public static void salvarFila(UPA upa) {
        try (FileWriter fw = new FileWriter(ARQUIVO_FILA)) {
            fw.write("nome,cpf,prioridade,chegada\n");

            for (Paciente p : upa.getFilaVermelha()) {
                fw.write(p.getNome() + "," + p.getCpf() + ",VERMELHA," + p.getChegadaFilaTimestamp() + "\n");
            }
            for (Paciente p : upa.getFilaAmarela()) {
                fw.write(p.getNome() + "," + p.getCpf() + ",AMARELA," + p.getChegadaFilaTimestamp() + "\n");
            }
            for (Paciente p : upa.getFilaVerde()) {
                fw.write(p.getNome() + "," + p.getCpf() + ",VERDE," + p.getChegadaFilaTimestamp() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar fila em arquivo: " + e.getMessage());
        }
    }

    // Lê o arquivo e mostra os pacientes que ainda estão na fila
    public static void mostrarFila() {
        File file = new File(ARQUIVO_FILA);
        if (!file.exists()) {
            System.out.println("Nenhum arquivo de fila encontrado.");
            return;
        }

        System.out.println("\n===== PACIENTES AINDA NA FILA =====");
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_FILA))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 4) {
                    String nome = partes[0];
                    String cpf = partes[1];
                    String prioridade = partes[2];
                    String chegada = partes[3];
                    System.out.println("Nome: " + nome + " | CPF: " + cpf +
                            " | Prioridade: " + prioridade + " | Chegada: " + chegada);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo da fila: " + e.getMessage());
        }
    }
}