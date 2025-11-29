package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // UPA CRIADA
        UPA upa1 = new UPA("Campo da Liga", "Rua do Prado");

        // ENFERMEIRO CRIADO
        Enfermeiro enfermeiro = new Enfermeiro("Pablo", "99999999999", "10/10/1980", "123", "12345", upa1);

        //  ATENDENTE CRIADO
        Atendente atendente = new Atendente("Chico Carlos", "44444444444", "04/04/2004", "1234", "12345", upa1);

        // MÉDICO CRIADO
        Medico medico = new Medico("Lucio", "555555555555", "05/05/2005", "54321", "54321", upa1, Prioridade.VERDE);

        // PACIENTE CRIADO
        Paciente p1 = new Paciente("Pedro SUPREMO", "11111111111", "01/01/2001", "saude1+@gmail.com", "saude+1", "20:34");

        // AUTENTICANDO FUNCIONARIOS
        enfermeiro.autenticar("123", "12345");
        atendente.autenticar("1234", "12345");

        // LOGIN DE PACIENTES
        p1.login("saude1+@gmail.com",  "saude+1");

        // TRIAGEM DE PACIENTES PELO ENFERMEIRO
        enfermeiro.triarPaciente(p1, Prioridade.VERDE);

        // CADASTRO DE PACIENTES PELO ATENDENTE
        atendente.cadastrarPaciente(p1);

        // PACIENTES ADICIONADOS NA FILA PELO ATENDENTE
        atendente.adicionarFila(p1, upa1);


        // TESTE
        System.out.println(upa1.getFilaVerde());
        enfermeiro.encaminharParaMedico(p1);
        medico.atenderPaciente(p1);
        //medico.encaminharParaEnfermaria(p1);
        enfermeiro.finalizarAtendimento(p1);

        System.out.println(upa1.getFilaVerde());




        //TESTE PARA FINALIZAR ATENDIMENTO NA ENFERMARIA
        //enfermeiro.finalizarAtendimento(p1);

    }
}
