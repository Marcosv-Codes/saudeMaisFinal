package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // UPA CRIADA
        UPA upa1 = new UPA("Campo da Liga", "Rua do Prado");

        // GESTOR CRIADO
        Gestor gestor = new Gestor("Gestor", "77777777777", "10/10/1990", "321", "321", upa1);

        // ENFERMEIRO CRIADO
       Enfermeiro enfermeiro = new Enfermeiro("Enfermeiro", "99999999999", "10/10/1980", "123", "12345", upa1);

        //  ATENDENTE CRIADO
        Atendente atendente = new Atendente("Atendente", "44444444444", "04/04/2004", "1234", "12345", upa1);

        // MÉDICO CRIADO
        Medico medico1 = new Medico("Médico VERDE", "555555555555", "05/05/2005", "54321", "54321", upa1, Prioridade.VERDE);
        Medico medico2 = new Medico("Médico AMARELO", "555555555555", "05/05/2006", "5432", "5432", upa1, Prioridade.AMARELA);
        Medico medico3 = new Medico("Médico VERMELHO", "555555555555", "05/05/2007", "543", "543", upa1, Prioridade.VERMELHA);

        // PACIENTE CRIADO
        Paciente p1 = new Paciente("Paciente 1", "11111111111", "01/01/2001", "saude1+@gmail.com", "saude+1", "20:34");
        Paciente p2 = new Paciente("Paciente 2", "22222222222", "01/01/2002", "saude2+@gmail.com", "saude+2", "20:35");
        Paciente p3 = new Paciente("Paciente 3", "3333333333", "01/01/2003", "saude3+@gmail.com", "saude+3", "20:36");

        // AUTENTICANDO FUNCIONARIOS
        gestor.autenticar("321", "321");

        enfermeiro.autenticar("123", "12345");

        atendente.autenticar("1234", "12345");

        medico1.autenticar("54321", "54321");
        medico2.autenticar("5432", "5432");
        medico3.autenticar("543", "543");


        // LOGIN DE PACIENTES
        p1.login("saude1+@gmail.com",  "saude+1");
        p2.login("saude2+@gmail.com",  "saude+2");
        p3.login("saude3+@gmail.com",  "saude+3");

        // TRIAGEM DE PACIENTES PELO ENFERMEIRO
        enfermeiro.triarPaciente(p1, Prioridade.VERDE);
        enfermeiro.triarPaciente(p2, Prioridade.AMARELA);
        enfermeiro.triarPaciente(p3, Prioridade.VERMELHA);

        // CADASTRO DE PACIENTES PELO ATENDENTE
        atendente.cadastrarPaciente(p1);
        atendente.cadastrarPaciente(p2);
        atendente.cadastrarPaciente(p3);

        // PACIENTES ADICIONADOS NA FILA PELO ATENDENTE
        atendente.adicionarFila(p1, upa1);
        atendente.adicionarFila(p2, upa1);
        atendente.adicionarFila(p3, upa1);

        // GESTOR MONITORA A FILA NESTE MOMENTO
        gestor.monitorarFilas();

        // CHAMANDO OS PACIENTES PELA ORDEM DE PRIORIDADE
        upa1.chamarProximo();
        upa1.chamarProximo();
        upa1.chamarProximo();

        // GESTOR MONITORA NOVAMENTE A FILA APOS OS PACIENTES SEREM CHAMADOS
        gestor.monitorarFilas();

        // MEDICO ATENDE -> ENCAMINHA AO ENFERMEIRO -> ENFERMEIRO FINALIZA O ATENDIMENTO
        medico3.atenderPaciente(p3);
        medico3.encaminharParaEnfermaria(p3);
        enfermeiro.finalizarAtendimento(p3);

        // MEDICO ATENDE -> ENCAMINHA AO ENFERMEIRO -> ENFERMEIRO FINALIZA O ATENDIMENTO
        medico2.atenderPaciente(p2);
        medico2.encaminharParaEnfermaria(p2);
        enfermeiro.finalizarAtendimento(p2);

        // MEDICO ATENDE -> FINALIZA O ATENDIMENTO
        medico1.atenderPaciente(p1);
        medico1.finalizarAtendimento(p1);

        // GESTOR GERA O RELATORIO
        gestor.gerarRelatorioSimples();
    }
}
